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
    public void UserDaoImplTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao ud = (UserDao)app.getBean("userDao");
        ud.save();
    }
}
