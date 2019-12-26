package top.franxx.blog.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.franxx.blog.aop.Operation;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.User;
import top.franxx.blog.service.UserService;
import top.franxx.blog.utils.ConstantVal;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager myAuthenticationManager;
    @Autowired
    DefaultKaptcha defaultKaptcha;
    /**
     * 显示所有用户
     * @param page
     * @param limit
     * @return
     */
    @Operation("查看用户")
    @RequestMapping("/list")
    public LUDataGridResult ListUser(String username,Integer page,Integer limit){
        if (username==null||username.equals(""))
            return userService.findAllUser(page,limit);
        else
            return userService.findUserByName(username,page,limit);

    }
    /**
     * 添加用户
     * @param user
     * @return
     */
    @Operation("添加用户")
    @RequestMapping("/add")
    public BlogResult addUser(User user){
        return userService.addUser(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Operation("更新用户")
    @RequestMapping("/update")
    public BlogResult updateUser(User user){
        //System.out.println(user);
        return userService.updateUser(user);
    }
    /**
     * 根据id删除用户
     * @param usersId
     * @return
     */
    @Operation("删除用户")
    @RequestMapping("/delete")
    public BlogResult deleteUser(Long usersId){
        return userService.deleteUser(usersId);
    }
    /**
     * 根据id批量删除用户
     * @param uids 用于通过jquery的ajax请求发送过来数组参数格式为 uids[] ,所以需要通过@RequestParam指定名称参数绑定
     * @return
     */
    @Operation("批量删除用户")
    @RequestMapping("/batch_delete")
    public BlogResult deleteUser(@RequestParam(value = "uids[]") Long [] uids){
        return userService.batchDeleteUser(uids);
    }
   /* *//**
     * 用户登陆
     * @param username
     * @param password
     * @return
     *//*
    @RequestMapping(value="/login", method= RequestMethod.POST)//使用springsecurity校验方式，此方法不被使用
    public BlogResult userLogin(String username, String password,String captcha, HttpServletRequest request, HttpServletResponse response) {
        try {
            String s = request.getSession().getAttribute(ConstantVal.CHECK_CODE).toString();
            if (!captcha.equals(s)){
                return BlogResult.build(400,"验证码错误");
            }
            BlogResult result = userService.userLogin(request,response,username,password);
           // return result;
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            //使用SpringSecurity拦截登陆请求 进行认证和授权
            Authentication authenticate = myAuthenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            //使用redis session共享
            //HttpSession session = request.getSession();
           // session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return BlogResult.build(500, ExceptionUtil.getStackTrace(e));
        }

    }

    *//**
     * 用户注销登录
     * @param
     * @return
     *//*
    @RequestMapping(value="/logout", method= RequestMethod.POST)//使用springsecurity校验方式，此方法不被使用
    public BlogResult userLogout(String token){
        BlogResult result = null;
        try {
            result = userService.userLogout(token);
        } catch (Exception e) {
            e.printStackTrace();
            result = BlogResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }*/
    /*@RequestMapping("/info")
    @Deprecated
    public BlogResult userInfo(String token){
        return userService.findUserByRememberMeToken(token);
    }*/
    @RequestMapping(value = "/username")
    public BlogResult currentUserName(Authentication authentication) {
        return BlogResult.ok(authentication.getName());
    }
    @Operation("更改密码")
    @RequestMapping(value = "/change_pwd")
    public BlogResult updatePassword(String old, String new1, String new2, HttpServletRequest request,HttpServletResponse response) {
        BlogResult result = userService.changePassword(old,new1,new2);;
        return  result;
    }
    @RequestMapping(value = "/change_info")
    public BlogResult updateUserInfo() {
      return BlogResult.build(400,"管理员未开启个人信息管理功能");
    }
    @RequestMapping(value = "/number")
    public BlogResult count() {
        return userService.countUser();
    }
    @RequestMapping("/captcha.jpg")
    @Operation("获取验证码")
    public void applyCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
       // R r = new R();
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = defaultKaptcha.createText();
        //生成图片验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        //保存到session
        request.getSession().setAttribute(ConstantVal.CHECK_CODE, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        //return r;
    }
}
