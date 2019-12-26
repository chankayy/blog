package top.franxx.blog.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.User;
import top.franxx.blog.service.UserService;
import top.franxx.blog.utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //在Handler执行之前处理
        String url = request.getRequestURI();
        if (url.indexOf("login")>=0)
            return true;
        //判断用户是否登录
        //从cookie中取token
        String token = CookieUtils.getCookieValue(request, "BLOG_TOKEN");
        if (token==null){
            response.sendRedirect("/page/login/login.html");
            return  false;
        }
        //根据token换取用户信息，调用sso系统的接口。
        BlogResult result =  userService.getUserByToken(token);
        if (result.getStatus() == 200) {
            User user = (User) result.getData();
            //取不到用户信息
            if (null == user) {
                //跳转到登录页面，把用户请求的url作为参数传递给登录页面。
                response.sendRedirect("/page/login/login.html");
                //返回false
                return false;
            }
            //取到用户信息，放行
            //把用户信息放到request中
            request.setAttribute("user",user);
            //返回值决定handler是否执行。true：执行，false：不执行。
            return true;
        }
        response.sendRedirect("/page/login/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // handler执行之后，返回ModelAndView之前

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 返回ModelAndView之后。
        //响应用户之后。

    }
}
