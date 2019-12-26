package top.franxx.blog.service;

import org.springframework.stereotype.Service;
import top.franxx.blog.pojo.BlogResult;
import top.franxx.blog.pojo.LUDataGridResult;
import top.franxx.blog.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface UserService {
   /**
    * 通过格式分页查找用户
    * @param page
    * @param limit
    * @return
    */
   LUDataGridResult findAllUser(Integer page, Integer limit);

   /**
    * 通过用户名分页查找用户
    * @param name
    * @return
    */
   LUDataGridResult findUserByName(String name,Integer page, Integer limit);
   /**
    * 添加用户
    * @param user
    * @return
    */
   BlogResult addUser(User user);

   /**
    * 修改用户
    * @param user
    * @return
    */
   BlogResult updateUser(User user);

   /**
    * 根据ID删除用户
    * @param id
    * @return
    */
   BlogResult deleteUser(Long id);

   /**
    * 批量删除id
    * @param ids
    * @return
    */
   BlogResult batchDeleteUser(Long []  ids);

   /**
    * 通过令牌获取用户信息
    * @param token
    * @return
    */
   @Deprecated
   BlogResult getUserByToken(String token);

   /**
    * 用户登陆
    * @param username
    * @param password
    * @param request
    * @param response
    * @return
    */
   @Deprecated
   BlogResult userLogin(HttpServletRequest request,HttpServletResponse response,String username, String password);

   /**
    * 检测数据是否合格
    * @param content 数据
    * @param type 类型
    * @return
    */
   @Deprecated
   BlogResult checkData(String content, Integer type);
   /**
    * 用户注销登陆
    * @param token
    * @return
    */
   @Deprecated
   BlogResult userLogout(String token);

   /**
    * 供springsecurity使用
    * @return
    */
   User findUserByUsername(String username);

   /**
    * 获取用户人数
    * @return
    */
   BlogResult countUser();

   /**
    * 更改密码
    * @param old
    * @param new1
    * @param new2
    * @return
    */
   BlogResult changePassword(String old,String new1,String new2);
/*   *//**
    * 通过springsecurity的记住密码token获取用户
    * @param token
    * @return
    *//*
   BlogResult findUserByRememberMeToken(String token);*/
}
