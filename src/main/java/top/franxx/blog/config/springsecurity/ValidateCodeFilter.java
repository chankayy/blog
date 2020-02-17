package top.franxx.blog.config.springsecurity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.franxx.blog.utils.ConstantVal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
public class ValidateCodeFilter extends OncePerRequestFilter {  //保证过滤器每次请求只会被调用一次

    private AuthenticationFailureHandler authenticationFailureHandler;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //当请求路径为/authentication/form，且请求为POST请求时，才执行验证。（对应登录页面发送的请求）
        if (StringUtils.equals("/login", request.getRequestURI())
                && StringUtils.equals(request.getMethod(), "POST")) {

            try {

                validate((request));
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }
        }

        filterChain.doFilter(request, response);
    }

    private void validate(HttpServletRequest request) throws ServletRequestBindingException, ValidateCodeException {
        //从请求中取出之前存入session的验证码
        String s = request.getSession().getAttribute(ConstantVal.CHECK_CODE).toString();
        //获取form表单中用户输入的验证码
        String codeInRequest = ServletRequestUtils.getStringParameter(request, "captcha");  //对应form表单中图片name
        String n = ServletRequestUtils.getStringParameter(request, "username");
        String p = ServletRequestUtils.getStringParameter(request, "password");
        System.out.println(n+"--"+p);
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码不能为空");
        }
        if (s == null) {
            throw new ValidateCodeException("验证码不存在");
        }
        if (!StringUtils.equals(s, codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        request.removeAttribute(ConstantVal.CHECK_CODE);
    }
}