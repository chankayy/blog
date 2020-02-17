package top.franxx.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.franxx.blog.interceptor.LoginInterceptor;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/index.html").addPathPatterns("/page/**").addPathPatterns("/user/**").addPathPatterns("/news/**");
       // addInterceptors(registry);
    }
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        //设置默认页
        registry.addViewController( "/" ).setViewName( "forward:/index.html" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        //addViewControllers( registry );
    }
}
