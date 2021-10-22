package com.Factory;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

/**
 * @Auther: YS
 * @Date: 2021/10/21 21:10
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
//工厂静态方法实例化
//public class StaticFactory {
//    public static UserDao UserDao(){
//        return (new UserDaoImpl());
//    }
//}

//工厂实例方法实例化
public class StaticFactory {
    public  UserDao UserDao(){
        return (new UserDaoImpl());
    }
}