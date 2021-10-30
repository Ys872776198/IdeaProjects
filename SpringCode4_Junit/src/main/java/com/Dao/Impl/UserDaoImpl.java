package com.Dao.Impl;

import com.Dao.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Auther: YS
 * @Date: 2021/10/30 21:23
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("Hello UserDaoImpl");
    }

    public UserDaoImpl() {
        System.out.println("我创建了UserDaoImpl");
    }

}
