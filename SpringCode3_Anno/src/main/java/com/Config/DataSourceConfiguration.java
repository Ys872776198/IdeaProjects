package com.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Auther: YS
 * @Date: 2021/10/25 22:28
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */

//当${jdbc.driver}在applicationContext.xml中可以直接解析，但是在APL当中系统会直接默认为字符串，
//        因此，就会出现Could not load driverClass ${jdbc.driver}的警告
//正确的用法是将${jdbc.driver}转换成字符串




//相当于 <context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")   //Spring会将该方法的返回值以 指定的名称 存入到Spring容器当中
    public DataSource getDataSource() throws PropertyVetoException {

//        实例化数据源对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        配置数据源基本连接数据
        cpds.setDriverClass(driver);
        cpds.setJdbcUrl(url);
        cpds.setUser(username);
        cpds.setPassword(password);

//        返回数据源对象
        return cpds;
    }
}
