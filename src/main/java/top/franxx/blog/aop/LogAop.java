package top.franxx.blog.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.franxx.blog.config.springsecurity.MyUserDetail;
import top.franxx.blog.pojo.Log;
import top.franxx.blog.service.LogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@Slf4j
@Component
@Aspect
public class LogAop {
    @Autowired
    private LogService logService;
    private Date startTime;
    //private Logger logger = LoggerFactory.getLogger(LogAop.class);
    @Pointcut("execution( * top.franxx.blog.controller.*.*(..))")
    private void log(){}
    @Before("log()")
    public void before(){
        startTime = new Date();
    }
    @After("log()")
    public void after(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // controller类
        Class<? extends Object> z = joinPoint.getTarget().getClass();
        String controllerOperation = z.getName();
        if (z.isAnnotationPresent(Operation.class)) {
            // 当前controller操作的名称
            controllerOperation = z.getAnnotation(Operation.class).value();
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 当前被访问的方法
        Method method = signature.getMethod();
        // z类下的所有方法
        Method[] methods = z.getMethods();
        String methodOperation = "";
        for (Method m : methods) {
            if (m.equals(method)) {
                methodOperation = m.getName();
                if (method.isAnnotationPresent(Operation.class)) {
                    // 当前执行方法操作的名称)
                    methodOperation = method.getAnnotation(Operation.class).value();
                    UserDetails user = null;
                    try{//获取登录用户的信息
                         user = (MyUserDetail) SecurityContextHolder.getContext()
                                .getAuthentication()
                                .getPrincipal();
                    }catch (Exception e){
                    }
                    Log l = new Log();
                    if(user != null){
                        l.setLogUserId(((MyUserDetail) user).getUserId());
                        /*System.out.println(user.getUsername() + " 执行了 " + controllerOperation + " 下的  " + methodOperation + " 操作！ ip地址为"
                                + request.getRemoteHost()+"  请求方式为"+request.getMethod());*/
                        log.info(user.getUsername() + " 执行了 " + controllerOperation + " 下的  " + methodOperation + " 操作！ ip地址为"
                                + getIpAddr(request)+"  请求方式为"+request.getMethod());
                    }else{
                        l.setLogUserId(0l);
                        /*System.err.println("游客      执行了 " + controllerOperation + " 下的  " + methodOperation + " 操作！ ip地址为"
                                + request.getRemoteHost()+"  请求方式为"+request.getMethod());*/
                        log.info("游客    执行了 " + controllerOperation + " 下的  " + methodOperation + " 操作！ ip地址为"
                                + getIpAddr(request)+"  请求方式为"+request.getMethod());
                    }
                    if(user ==null){
                        return;
                    }
                    l.setLogContent(user.getUsername() + " 执行了 " + controllerOperation + " 下的  " + methodOperation + " 操作！ ip地址为"
                            + getIpAddr(request)+"  请求方式为"+request.getMethod());
                    l.setLogController(controllerOperation);
                    l.setLogIp(getIpAddr(request));
                    l.setLogMethod(methodOperation);
                    l.setLogReq(request.getMethod());
                    l.setLogTaking(new Date().getTime()-startTime.getTime()+"");
                    l.setLogStatus(0);
                    l.setLogUrl(request.getRequestURL().toString());
                    Date d = new Date();
                    l.setLogTime(d);
                    l.setLogUserId(((MyUserDetail) user).getUserId());
                    try {
                        logService.addLog(l);
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.err.println("日志插入错误！");
                    }
                }
            }
        }

    }
    /*@AfterThrowing("log()")
    public void throwing(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // controller类
        Class<? extends Object> z = joinPoint.getTarget().getClass();
        String controllerOperation = z.getName();
        if (z.isAnnotationPresent(Operation.class)) {
            // 当前controller操作的名称
            controllerOperation = z.getAnnotation(Operation.class).value();
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 当前被访问的方法
        Method method = signature.getMethod();
        // z类下的所有方法
        Method[] methods = z.getMethods();
        String methodOperation = "";
        for (Method m : methods) {
            if (m.equals(method)) {
                methodOperation = m.getName();
                if (method.isAnnotationPresent(Operation.class)) {
                    // 当前执行方法操作的名称)
                    methodOperation = method.getAnnotation(Operation.class).value();
                    UserDetails user = null;
                    try{//获取登录用户的信息
                        user = (UserDetails) SecurityContextHolder.getContext()
                                .getAuthentication()
                                .getPrincipal();
                    }catch (Exception e){
                    }
                    if(user != null){
                        System.err.println(user.getUsername() + " 执行了 " + controllerOperation + " 下的  " + methodOperation + " 操作！ ip地址为"
                                + request.getRemoteHost()+"  请求方式为 "+request.getMethod()+"请求状态为"+"异常");
                    }else{
                        System.err.println("游客      执行了 " + controllerOperation + " 下的  " + methodOperation + " 操作！ ip地址为"
                                + request.getRemoteHost()+"  请求方式为 "+request.getMethod() +"请求状态为"+"异常");
                    }
                    try {


                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.err.println("日志插入错误！");
                    }
                }
            }
        }
    }*/
    private String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        //ipAddress = request.getRemoteAddr();
        ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }

        }

        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
