package com.YS.Service.Impl;

import com.YS.Dao.UserDao;
import com.YS.Service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Auther: YS
 * @Date: 2021/10/30 23:16
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    private com.YS.Dao.UserDao UserDao;

    public void setUserDao(UserDao userDao) {
        UserDao = userDao;
    }

    public UserServiceImpl() {
        System.out.println("我创建了UserServiceImpl");
    }

    public void Init(){
        System.out.println("初始化");
    }

    public void Destory(){
        System.out.println("销毁了");
    }

    @Override
    public void save() {
        UserDao.save();
    }
}
