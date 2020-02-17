//package top.franxx.blog;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import top.franxx.blog.mapper.UserMapper;
//import top.franxx.blog.pojo.User;
//
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = BlogApplication.class)
//public class SpringBootJunitTest {
//    @Autowired
//    private UserMapper userMapper;
//    @Test
//    public void findAllTest(){
//        User user = new User();
//        user.setUserName("tt");
//        user.setPassword("dddd");
//        user.setUserDesc("sss");
//        user.setUserEmail("aaaa");
//        user.setUserGrade(4);
//        user.setUserStatus(0);
//        user.setUserEndTime(new Date());
//        System.out.println("QWEWQ");
//        userMapper.insert(user);
//    }
//    @Test
//    public void selectUser(){
//       List<User> list= userMapper.selectByExample(null);
//       for (User u:list){
//           System.out.println(u.getUserName());
//       }
//    }
//}
