package com.Service.Impl;

import com.Dao.UserDao;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ResourceBundle;

/**
 * @Auther: YS
 * @Date: 2021/10/25 22:18
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
@Service("userService")
//@PropertySource("classpath:jdbc.properties")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
    private com.Dao.UserDao UserDao;



    public UserServiceImpl() {
        System.out.println("我创建了UserServiceImpl");
//        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
//        rb.getString("jdbc.driver");
//        System.out.println(rb.getString("jdbc.driver"));
    }

    @PostConstruct
    public void Init(){
        System.out.println("初始化");
    }

    @PreDestroy
    public void Destory(){
        System.out.println("销毁了");
    }

    @Override
    public void save() {
        System.out.println("Hello UserServiceImpl");
    }
}
