package com.dao.impl;

import com.Demo.User;
import com.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: YS
 * @Date: 2021/10/19 20:16
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    private String name;
    private String age;
    private List<String> Stringlist;
    private Map<String , User> UserMap;
    private Properties prop;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setStringlist(List<String> stringlist) {
        Stringlist = stringlist;
    }

    public void setUserMap(Map<String, User> userMap) {
        UserMap = userMap;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    @Override
    public void save() {
        System.out.println("helloSpring!!");
        System.out.println("name:" + name + "-----" + "age:" + age);
        System.out.println("List：" + Stringlist);
        System.out.println("Map<String, User>:" + UserMap);
        System.out.println("Properties:" + prop);
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
