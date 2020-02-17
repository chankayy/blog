package top.franxx.blog.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import top.franxx.blog.config.springsecurity.MyUserDetail;

public class UserUtil {
    public  static MyUserDetail getUserDetail(){
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return user;
    }
}
