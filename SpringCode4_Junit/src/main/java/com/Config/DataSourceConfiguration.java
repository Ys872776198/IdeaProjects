package com.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Auther: YS
 * @Date: 2021/10/30 21:34
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
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

    @Bean("dataSource")
    public DataSource getDataSource() throws PropertyVetoException {
//       实现一个数据源对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        设置数据源的基本连接数据
        cpds.setDriverClass(driver);
        cpds.setJdbcUrl(url);
        cpds.setUser(username);
        cpds.setPassword(password);

        return cpds;


    }



}
