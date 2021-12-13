package com.YS.Dao.Impl;

/**
 * @Auther: YS
 * @Date: 2021/11/29 21:31
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class User {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
