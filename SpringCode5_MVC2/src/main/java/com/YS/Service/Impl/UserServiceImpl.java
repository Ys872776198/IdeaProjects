package com.YS.Service.Impl;

import com.YS.Dao.UserDao;
import com.YS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Auther: YS
 * @Date: 2021/11/10 20:17
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
    private com.YS.Dao.UserDao UserDao;

    public void setUserDao(com.YS.Dao.UserDao userDao) {
        UserDao = userDao;
    }

    public UserServiceImpl() {
        System.out.println("我创建了UserServiceImpl");
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
        UserDao.save();
    }
}
