package com.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: YS
 * @Date: 2021/10/25 22:30
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
@Configuration  //标志该类是Spring核心配置类
@ComponentScan("com") //相当于 <context:component-scan base-package="com"></context:component-scan>
@Import({DataSourceConfiguration.class})    //相当于  <import resource="applicationContext-UserDao.xml"></import>
                                            //这里面填写的是类，且内部为数组,在多个需要导入的类时（{a.class, b.class,.....}）
public class SpringConfiguration {
}
