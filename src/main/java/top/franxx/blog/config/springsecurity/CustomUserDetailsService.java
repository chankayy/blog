package top.franxx.blog.config.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import top.franxx.blog.pojo.User;
import top.franxx.blog.service.UserService;

import java.util.ArrayList;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //--------------------认证账号
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        //-------------------开始授权
        ArrayList<GrantedAuthority> list = new ArrayList<>();

        list.add(new SimpleGrantedAuthority("ROLE_"+user.getUserGrade()));

        org.springframework.security.core.userdetails.User u = new MyUserDetail(user.getUsersId(),username,user.getPassword(),user.getUserGrade(),true,true,true,user.getUserStatus().equals(0),list);

        return u;
    }
}
