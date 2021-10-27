import Dao.UserDao;
import Service.Impl.UserServiceImpl;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.xpath.internal.objects.XObject;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Auther: YS
 * @Date: 2021/10/22 22:43
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class CodeTest {

//    数据源连接测试（C3P0）
    @Test
    public void C3P0Test() throws PropertyVetoException, SQLException {
////        数据源连接测试（C3P0），手动测试
////        实例化数据源对象
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
////        设置数据源的基本连接数据
//        cpds.setDriverClass("com.mysql.jdbc.Driver");
//        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
//        cpds.setUser("root");
//        cpds.setPassword("root");
//        Connection cn = cpds.getConnection();   //此处检查是否连接成功
//        System.out.println(cn);
//        cn.close();

////        数据源连接测试（C3P0）,解耦,利用properties配置文件
////       先读取配置文件
//        ResourceBundle rb = ResourceBundle.getBundle("jdbc");   //getBundle 填写的是resources目录下的文件名，不用带后缀
//        String driver = rb.getString("jdbc.driver");
//        String url = rb.getString("jdbc.url");
//        String username = rb.getString("jdbc.username");
//        String password = rb.getString("jdbc.password");
//
////        创建数据源连接对象
//        ComboPooledDataSource cd = new ComboPooledDataSource();
////        设置数据源连接的基本数据
//        cd.setDriverClass(driver);
//        cd.setJdbcUrl(url);
//        cd.setUser(username);
//        cd.setPassword(password);
//
//        Connection cn = cd.getConnection();
//        System.out.println(cn);
//        cn.close();

//        数据源连接测试（C3P0）,解耦,利用Spring配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource cp = (ComboPooledDataSource)app.getBean("c3p0");
        Connection cn = cp.getConnection();
//        System.out.println(cn);
//        cn.close();

        PreparedStatement ps = cn.prepareStatement("select * from dept where deptno = ?");
        ps.setInt(1, 10);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            int deptno = rs.getInt(1);      //这里面的 1 代表查询结果的第一行，同时获取的类型要和数据库对应的类型一致,将结果集放到循环中
            String dname = rs.getString(2);
            String loc = rs.getString(3);

            System.out.println(deptno + "\t" + dname + "\t" + loc);

            System.out.println("账号存在，登录成功！");
        }else {
            System.out.println("账号不存在，登录失败！");
        }

        rs.close();
        ps.close();
        cn.close();

//        Statement st = cn.createStatement();
//        String sql = "delete from emp where empno = 8888";
//        int i = st.executeUpdate(sql);
////        System.out.println("i" + i);
//
//        if (i > 0){
//            System.out.println("删除成功！");
//        }else {
//            System.out.println("删除失败！");
//        }
//
//        st.close();
//        cn.close();

    }

//    数据源连接测试（Druid）
    @Test
    public void DruidTest() throws SQLException {
////        数据源连接测试（Druid），手动测试
////        实例化数据源对象
//        DruidDataSource dds = new DruidDataSource();
////        设置数据源的基本链接数据
//        dds.setDriverClassName("com.mysql.jdbc.Driver");
//        dds.setUrl("jdbc:mysql://localhost:3306/test1");
//        dds.setUsername("root");
//        dds.setPassword("root");
//        Connection cn = dds.getConnection();
//        System.out.println(cn);
//        cn.close();

////        数据源连接测试（Druid）,解耦,利用properties配置文件
////        先读取配置文件
//        ResourceBundle rb = ResourceBundle.getBundle("jdbc");   //getBundle 填写的是resources目录下的文件名，不用带后缀
//        String driver = rb.getString("jdbc.driver");
//        String url = rb.getString("jdbc.url");
//        String username = rb.getString("jdbc.username");
//        String password = rb.getString("jdbc.password");
//
////        实例化数据源对象
//        DruidDataSource ds = new DruidDataSource();
////        设置数据源的基本连接数据
//        ds.setDriverClassName(driver);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//
//        Connection cn = ds.getConnection();
//        System.out.println(cn);
//        cn.close();

//        数据源连接测试（Druid）,解耦,利用Spring配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dd = (DruidDataSource)app.getBean("druid");
        Connection cn = dd.getConnection();
        System.out.println(cn);
        cn.close();
    }

    @Test
    public void AnnoTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl us = (UserServiceImpl) app.getBean("userService");
        us.save();
    }

}
