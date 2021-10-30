package com.YS.Dao.Impl;

import com.YS.Dao.UserDao;

/**
 * @Auther: YS
 * @Date: 2021/10/30 23:13
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("Hello UserDaoImpl");
    }

    public UserDaoImpl() {
        System.out.println("我创建了UserDaoImpl");
    }
}
