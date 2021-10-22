package com.dao.impl;

import com.dao.UserDao;

/**
 * @Auther: YS
 * @Date: 2021/10/19 20:16
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("helloSpring!!");
    }

    public UserDaoImpl() {
        System.out.println("创建了UserDaoImpl。。。。");
    }

    public void init(){
        System.out.println("初始化。。。。。");
    }
    public void destory(){
        System.out.println("销毁了。。。。。");
    }

}
