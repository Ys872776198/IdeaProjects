package com.Demo;

/**
 * @Auther: YS
 * @Date: 2021/10/22 09:38
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class User {
    private String name;
    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
