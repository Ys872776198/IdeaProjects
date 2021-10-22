import com.Service.UserServiceDao;
import com.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: YS
 * @Date: 2021/10/19 20:36
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class UserDaoTest {
    @Test
//    测试bean的scope取值：Singleton 和 Prototype
    public void UserDaoImplTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao ud = (UserDao)app.getBean("userDao");
//        UserDao ud2 = (UserDao)app.getBean("userDao");
        ud.save();
//        ((ClassPathXmlApplicationContext) app).close();

        System.out.println(ud);
//        System.out.println(ud2);
    }

    @Test
    public void UserServiceImplTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceDao us = (UserServiceDao)app.getBean("userService");
        us.save();

    }


}