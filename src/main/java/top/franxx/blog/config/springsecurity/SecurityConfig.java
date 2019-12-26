
package top.franxx.blog.config.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.Writer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法权限控制
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    DataSource dataSource;
    //记住我的功能
    @Bean
    public PersistentTokenRepository getPersistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
        jdbcTokenRepositoryImpl.setDataSource(dataSource);
        //启动时创建一张表，这个参数到第二次启动时必须注释掉，因为已经创建了一张表
       // jdbcTokenRepositoryImpl.setCreateTableOnStartup(true);
        return jdbcTokenRepositoryImpl;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder  auth) throws  Exception{
        auth.userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                sendJson(httpServletResponse,BlogResult.build(400,"验证码错误"));
            }
        });
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
        http.csrf().disable();
        http.authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers( "/**/*.mp3","/**/captcha.jpg","/images/**","/**/*.ico","/**/*.js","/**/*.css","/**/*.json","/layui/**","/files/**","/page/login/login.html","/welcome.html").permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .antMatchers("/user/username","/user/number","/user/change_pwd").authenticated()
                .antMatchers("/news/**","/com/**","/comreply/**","/share/**").hasAnyRole("4","5")
                .antMatchers("/user/**","/message/**","/msgreply/**").hasRole("5")
                .anyRequest().authenticated()
                .and().rememberMe().tokenRepository(getPersistentTokenRepository()).tokenValiditySeconds(60*60*24).userDetailsService(customUserDetailsService()).alwaysRemember(true)/*.rememberMeCookieDomain("franxx.top")*/
                .and()
                .formLogin().loginPage("/page/login/login.html").loginProcessingUrl("/login").successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

                sendJson(httpServletResponse,BlogResult.ok());
            }
        }).failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                //AuthenticationException的子类有
                //UsernameNotFoundException 用户找不到
                //BadCredentialsException 坏的凭据
                //AccountStatusException 用户状态异常它包含如下子类
                //AccountExpiredException 账户过期
                //LockedException 账户锁定
                //DisabledException 账户不可用
                //CredentialsExpiredException 证书过期
                String msg = "用户或密码错误！";
                if (e instanceof LockedException){
                    msg = "用户被限制登录！";
                }
                sendJson(httpServletResponse,BlogResult.build(403,"登录失败",msg));
            }
        })
                .and()
                //权限拒绝的页面
                .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {//在rememberme的情况下，访问权限不足的url会被认为身份认证失败，需要在此方法处理
            @Override
            public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                if(isAjaxRequest(httpServletRequest)){
                    sendJson(httpServletResponse,new LUDataGridResult(1,"用户权限不足",0,null));
                }else{
                    httpServletResponse.sendRedirect("/page/login/login.html");
                }
            }
            public  boolean isAjaxRequest(HttpServletRequest request) {//判断是否是ajax请求
                String ajaxFlag = request.getHeader("X-Requested-With");
                return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
            }
        }).accessDeniedHandler(new AccessDeniedHandler() {//权限不足时进入此方法
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                sendJson(httpServletResponse,new LUDataGridResult(1,"用户权限不足",0,null));
            }
        });

         http.logout().logoutUrl("/user/logout").logoutSuccessHandler(new LogoutSuccessHandler() {
             @Override
             public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                sendJson(httpServletResponse,BlogResult.ok());
             }
         });
         http.sessionManagement().maximumSessions(1).expiredUrl("/page/login/login.html");
    }

    /**
     * 自定义UserDetailsService，授权
     * @return
     */
    @Bean
    public CustomUserDetailsService customUserDetailsService(){
        return new CustomUserDetailsService();
    }
    /**
     * 设置用户密码的加密方式
     * @return
     */
    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();

    }
    /**
     * AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * 返回 RememberMeServices 实例
     *
     * @return the remember me services
     */
    @Bean
    public RememberMeServices rememberMeServices() {
        JdbcTokenRepositoryImpl rememberMeTokenRepository = new JdbcTokenRepositoryImpl();
        // 此处需要设置数据源，否则无法从数据库查询验证信息
        rememberMeTokenRepository.setDataSource(dataSource);

        // 此处的 key 可以为任意非空值(null 或 "")，单必须和起前面
        // rememberMeServices(RememberMeServices rememberMeServices).key(key)的值相同
        PersistentTokenBasedRememberMeServices rememberMeServices =
                new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY", userDetailsService, rememberMeTokenRepository);

        // 该参数不是必须的，默认值为 "remember-me", 但如果设置必须和页面复选框的 name 一致
        rememberMeServices.setParameter("remember");
        return rememberMeServices;
    }
    private void sendJson( HttpServletResponse httpServletResponse,Object obj){
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        Writer out = null;
        try {
            out = httpServletResponse.getWriter();
            out.write(JsonUtils.objectToJson(obj));//回复ajax请求json数据
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


