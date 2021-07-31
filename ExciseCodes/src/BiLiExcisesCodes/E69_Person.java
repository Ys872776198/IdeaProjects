package BiLiExcisesCodes;

import java.io.Serializable;

/**
 * @Auther: YS
 * @Date: 2021/7/30
 * @Description: (接E71,E72,E73,E74)
 * @Version: 1.0
 */
public class E69_Person implements Serializable {
    private static final long serialVersionUID = 4936594418789723122L;
    //    定义不同作用域的属性
    private String name;
    int age;
    protected double high;
    public double weight;

//    定义不同作用域的方法
    private void Eat(){
        System.out.println("我吃饭");
        System.out.println("我的权限修饰符是private");
    }

    void Sleep(){
        System.out.println("我的权限修饰符是default");
        System.out.println("我睡觉");
    }

    protected void Play(String s){
        System.out.println("我的权限修饰符是protected");
        System.out.println("我在玩" + s);
    }

    @Override
    public String toString() {
        return "E69_Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", high=" + high +
                ", weight=" + weight +
                '}';
    }

    public String Add(int a, int b){
        return ("我的权限修饰符是public,计算结果：" + a + " + " + b + "=" + (a + b));
    }

    public static String Sub(int a, int b){
        return ("我的权限修饰符是public,另外我加了static，计算结果：" + a + " - " + b + "=" + (a - b));
    }

//    定义不同作用域的构造方法
    private E69_Person(String name){
        System.out.println("我的权限修饰符是private");
        this.name = name;
    }

    E69_Person(int age){
        System.out.println("我的权限修饰符是default");
        this.age = age;
    }

    protected E69_Person(double high, double weight){
        System.out.println("我的权限修饰符是protected");
        this.high = high;
        this.weight = weight;
    }

    public E69_Person(String name, int age, double high, double weight){
        System.out.println("我的权限修饰符是public");
        this.name = name;
        this.age = age;
        this.high = high;
        this.weight = weight;
    }

    public E69_Person(){

    }

}
