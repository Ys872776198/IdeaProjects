import com.Config.SpringConfiguration;
import com.Dao.UserDao;
import com.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Auther: YS
 * @Date: 2021/10/30 21:53
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
//当使用配置文件时@ContextConfiguration注解如此使用
//@ContextConfiguration(classes = {SpringConfiguration.class})
//当使用注解时@ContextConfiguration注解如此使用,{}里面是数组 如：{a.class, b.class, ....}
@ContextConfiguration(classes = {SpringConfiguration.class})
public class JunitTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("dataSource")        //@Autowired是按类型来匹配，当有多个同类型的Bean对象时，就要配合@Qualifier使用
    private DataSource dataSource;

    @Test
    public void SpringjJunitTest() throws SQLException {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        DataSource ds = (DataSource)ac.getBean("dataSource");
//        System.out.println(ds.getConnection());

//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        UserDao ud = (UserDao)ac.getBean("userDao");
//        ud.save();

        System.out.println(dataSource.getConnection());


    }
}
