import com.Config.DataSourceConfiguration;
import com.Config.SpringConfiguration;
import com.Service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: YS
 * @Date: 2021/10/25 22:26
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class CodeTest {
    @Test
    public void AnnoTest(){
        ApplicationContext aac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService us = (UserService)aac.getBean("userService");
        us.save();
    }

    @Test
    public void C3P0Test() throws SQLException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DataSource ds = (DataSource)ac.getBean("dataSource");
        Connection cnn = ds.getConnection();
        System.out.println(cnn);
    }
}
