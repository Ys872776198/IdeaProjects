package BiLiExcisesCodes;

/*
(E9)类的定义与使用
格式：public+class+名称
 */

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String sex;

    public  void setName(String n)
    {
        name = n;
    }

    public  String getName()
    {
        return name;
    }

    public void setAge(int n)
    {
        age = n;
    }

    public int getAge()
    {
        return age;
    }

    public void setSex(String n)
    {
        sex = n;
//        System.out.println("sc1：" + sex);
    }

    public String getSex()
    {
        return sex;
    }

    public void people()
    {
        while( true) {
            if ((getAge() < 0) || (getAge() > 100)) {
                System.out.println("年龄错误！");
                System.out.print("请重新输入：");
                Scanner sc = new Scanner(System.in);
                setAge(sc.nextInt());
//            } else if ((getSex() != "男") && (getSex() != "女")) {
//            } else if (("男".equals(getSex())) || ("女".equals(getSex()))) {
            } else if ((getSex().equals("男")) || (getSex().equals("女"))) {
                System.out.println("姓名：" + getName() + "\n" + "年龄：" + getAge() + "\n" + "性别：" + getSex());
                break;
            } else {
                System.out.println("性别错误！");
                Scanner sc = new Scanner(System.in);
                System.out.println("请重新输入：");
//                String a = sc.nextLine();
//                System.out.println("sc：" + a);
                setSex(sc.nextLine());
            }
        }
    }

//  必须存在构造方法，格式（没有返回值的类型，构造器的名字必须与类名一模一样）
//  作用：为了给以创建好的对象进行初始化。但是一般我们不会在空构造器中进行初始化

    public Person(){

    }

    public Person(String name,int age,String sex){
//        当形参名和属性名相同时，会发生就近原则(例:name=name; 系统会默认形参name的值赋给形参本身)。
//        那么我们就要表示属性的那个参数是，在前面加上this.
        this.name = name;
        this.age = age;
        this.sex = sex;
//        setName(name);
//        setAge(age);
//        setSex(sex);
    }

}


