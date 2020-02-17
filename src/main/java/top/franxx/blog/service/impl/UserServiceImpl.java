package top.franxx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.franxx.blog.config.springsecurity.Md5PasswordEncoder;
import top.franxx.blog.config.springsecurity.MyUserDetail;
import top.franxx.blog.mapper.PersistentLoginsMapper;
import top.franxx.blog.mapper.UserMapper;
import top.franxx.blog.pojo.*;
import top.franxx.blog.service.UserService;
import top.franxx.blog.utils.CookieUtils;
import top.franxx.blog.utils.JsonUtils;
import top.franxx.blog.utils.RedisUtil;
import top.franxx.blog.utils.UserUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
@PropertySource("classpath:resource.properties")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
  /*  @Autowired
    private PersistentLoginsMapper persistentLoginsMapper;*/
    @Autowired
    private RedisUtil redisUtil;
    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;
    @Value("${SSO_SESSION_EXPIRE}")
    private Integer SSO_SESSION_EXPIRE;
    @Override
    public LUDataGridResult findAllUser(Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        List<User> list = userMapper.selectByExampleWithBLOBs(null);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        for (User u:list){
            u.setPassword("");//不返回密码
        }
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public LUDataGridResult findUserByName(String name,Integer page, Integer limit) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameLike("%"+name+"%");
        List<User> list = userMapper.selectByExampleWithBLOBs(example);
        //判断是否查询成功
        if(list==null||list.size()==0){
            LUDataGridResult result = new LUDataGridResult();
            result.setData(null);
        };
        for (User u:list){
            u.setPassword("");//不返回密码
        }
        LUDataGridResult result = new LUDataGridResult();
        result.setData(list);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public BlogResult addUser(User user) {
        user.setUserEndTime(new Date());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
        return  BlogResult.ok();
    }

    @Override
    public BlogResult updateUser(User user) {
        User u = userMapper.selectByPrimaryKey(user.getUsersId());
        if (u==null){
            return BlogResult.build(400,"修改失败，用户不存在！");
        }
        User oldMes = userMapper.selectByPrimaryKey(user.getUsersId());
        if (user.getPassword()==null||user.getPassword().equals("")){
            user.setPassword(oldMes.getPassword());
            //user.setPassword(DigestUtils.md5DigestAsHex(oldMes.getPassword().getBytes()));
        }else{
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        }
        user.setUserEndTime(oldMes.getUserEndTime());
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsersIdEqualTo(user.getUsersId());
        userMapper.updateByExampleWithBLOBs(user,example);
        return BlogResult.ok();
    }

    @Override
    public BlogResult deleteUser(Long id) {
        try{
            userMapper.deleteByPrimaryKey(id);
            return BlogResult.ok();
        }catch (Exception e){
            return  BlogResult.build(400,"删除失败！");
        }

    }

    @Override
    public BlogResult batchDeleteUser(Long [] ids) {
        try{
            ArrayList<Long> idList = new ArrayList<Long>();
            idList.addAll(Arrays.asList(ids));//将数组转为容器
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUsersIdIn(idList);
            userMapper.deleteByExample(example);
            return  BlogResult.ok();
        }catch (Exception e){
            return BlogResult.build(400,"删除失败");
        }

    }

    @Override
    public BlogResult checkData(String content, Integer type) {
        //创建查询条件
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        //对数据进行校验：1、2、3分别代表username、phone、email
        //用户名校验
        if (1 == type) {
            criteria.andUserNameEqualTo(content);
            //电话校验
        } else if ( 2 == type) {

            //email校验
        } else {
            criteria.andUserEmailEqualTo(content);
        }
        //执行查询
        List<User> list = userMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return BlogResult.ok(true);
        }
        return BlogResult.ok(false);
    }
    @Override
    public BlogResult userLogin(HttpServletRequest request,HttpServletResponse response,String username, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);
        //如果没有此用户名
        if (null == list || list.size() == 0) {
            return BlogResult.build(400, "用户名或密码错误");
        }
        User user = list.get(0);
        //比对密码
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return BlogResult.build(400, "用户名或密码错误");
        }
        //生成token
        String token = UUID.randomUUID().toString();
        //保存用户之前，把用户对象中的密码清空。
        user.setPassword(null);
        //把用户信息写入redis
        redisUtil.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user),0);
        //设置session的过期时间
        redisUtil.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE,0);
        //添加cookie逻辑,cookie有效期是关闭浏览器就实效
        CookieUtils.setCookie(request, response, "BLOG_TOKEN", token);
        Properties props=System.getProperties();
        if (props.getProperty("os.name").toLowerCase().indexOf("windows")>=0){
            CookieUtils.setCookie(request, response, "BLOG_TOKEN", token,60*60*24);
        }else{
            Cookie cookie = new Cookie("BLOG_TOKEN", token);
            cookie.setDomain("franxx.top");
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        }

        //返回token
        return BlogResult.ok(token);
    }

    @Override
    public BlogResult getUserByToken(String token) {
        //根据token从redis中查询用户信息
        String json = redisUtil.get(REDIS_USER_SESSION_KEY + ":" + token,0);
        //判断是否为空
        if (StringUtils.isBlank(json)) {
            return BlogResult.build(400, "此session已经过期，请重新登录");
        }
        //更新过期时间
        redisUtil.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE,0);
        //返回用户信息
        return BlogResult.ok(JsonUtils.jsonToPojo(json, User.class));
    }

    @Override
    public BlogResult userLogout(String token) {

        //根据token从redis中查询用户信息
        String json = redisUtil.get(REDIS_USER_SESSION_KEY + ":" + token,0);
        //判断是否为空
        if (StringUtils.isBlank(json)) {
            return BlogResult.build(400, "此session已经过期，请重新登录");
        }
        //从redis中移除此登陆
        redisUtil.del(REDIS_USER_SESSION_KEY+":"+token);
        //返回用户信息
        return BlogResult.ok(JsonUtils.jsonToPojo(json, User.class));

    }

    @Override
    public User findUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> list = userMapper.selectByExampleWithBLOBs(example);
        if (list==null||list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public BlogResult countUser() {
        Integer num = userMapper.countByExample(null);
        if (num!=null){
            return BlogResult.ok(num);
        }else{
            return BlogResult.build(400,"获取用户人数失败");
        }
    }

    @Override
    public BlogResult changePassword(String old, String new1, String new2) {

        MyUserDetail userDetail = UserUtil.getUserDetail();
        if (userDetail==null){
            return BlogResult.build(400,"更改密码失败，用户未登录！");
        }
        User user = userMapper.selectByPrimaryKey(userDetail.getUserId());
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        if (user!=null&&!encoder.matches(old,user.getPassword())){
            return BlogResult.build(400,"更改密码失败，密码错误！");
        }
        if (!new1.equals(new2)){
            return BlogResult.build(400,"更改密码失败，两次密码不一致！");
        }
        user.setPassword(encoder.encode(new1));
        userMapper.updateByPrimaryKeyWithBLOBs(user);

        return BlogResult.ok();

    }

  /*  @Override
    public BlogResult findUserByRememberMeToken(String token) {
        System.out.println(token+"--"+ DigestUtils.md5DigestAsHex(token.getBytes()));
        PersistentLoginsExample example = new PersistentLoginsExample();
        PersistentLoginsExample.Criteria criteria = example.createCriteria();
        criteria.andTokenEqualTo(token);
        List<PersistentLogins> list = persistentLoginsMapper.selectByExample(example);
        if (list==null||list.isEmpty())
            return BlogResult.build(400,"Mikoto");
        return BlogResult.ok(list.get(0));
    }*/
}
