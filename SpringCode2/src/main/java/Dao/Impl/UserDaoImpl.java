package Dao.Impl;

import Dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Auther: YS
 * @Date: 2021/10/25 16:13
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("hello world!!!!");
    }

    public UserDaoImpl() {
        System.out.println("我创建了UserDaoImpl");
    }
}
