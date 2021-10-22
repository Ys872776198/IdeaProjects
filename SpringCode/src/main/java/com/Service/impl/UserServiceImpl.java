package com.Service.impl;

import com.Service.UserServiceDao;
import com.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: YS
 * @Date: 2021/10/21 21:57
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class UserServiceImpl implements UserServiceDao {

    private  UserDao UserDao;
//    public void setUserDao(UserDao ud) {
//        this.UserDao = ud;
//    }


    public UserServiceImpl(com.dao.UserDao userDao) {
        UserDao = userDao;
    }

    public UserServiceImpl() {
        System.out.println("创建了UserServiceImpl");
    }

    @Override
    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao ud = (UserDao)app.getBean("userDao");
        UserDao.save();
    }
}
