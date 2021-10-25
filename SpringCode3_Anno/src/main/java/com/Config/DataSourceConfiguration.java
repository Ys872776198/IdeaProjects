package com.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
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

@PropertySource("classpath:jdbc.properties") //相当于 <context:property-placeholder location="classpath:jdbc.properties"/>
public class DataSourceConfiguration {
    @Bean("dataSource")   //Spring会将该方法的返回值以 指定的名称 存入到Spring容器当中
    public DataSource getDataSource() throws PropertyVetoException {
//        实例化数据源对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        配置数据源基本连接数据
        cpds.setDriverClass("${jdbc.driver}");
        cpds.setJdbcUrl("${jdbc.url}");
        cpds.setUser("${jdbc.username}");
        cpds.setPassword("{jdbc.password}");

//        返回数据源对象
        return cpds;
    }
}
