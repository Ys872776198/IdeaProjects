package com.YS.Dao.Impl;

import com.YS.Dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Auther: YS
 * @Date: 2021/11/10 20:14
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
