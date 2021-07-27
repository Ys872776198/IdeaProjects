package BiLiExcisesCodes;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/7/26
 * @Description: 枚举(接E62_Gender)
 * @Version: 1.0
 */

/**
 * 枚举总结：
 * 只能够取特定值中的一个
 * 使用enum关键字
 * 所以的枚举类隐性的继承了java.lang.Enum（枚举实质上还是一个类！而每个被枚举的成员实质就是一个枚举类的实例，他们默认都是public static final的。可以直接用枚举名.成员名来调用）
 * 强烈建议当你需要定义一组常量时，使用枚举类型
 * 尽量不要使用枚举的高级特性，事实上高级特性都可以使用普通类来实现，没必要引入复杂性
 *
 */

//利用枚举(枚举为引用数据类型)
public class E62 {
    private String name;
    private int age;
    private E62_Gender sex;             //创建枚举类型的数据

    public E62_Gender getSex() {
        return sex;
    }

    public void setSex(E62_Gender sex) {
        this.sex = sex;
    }

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


    @Override
    public String toString() {
        return "E62{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public void people()
    {
        while( true) {
            if ((getAge() < 0) || (getAge() > 100)) {
                System.out.println("年龄错误！");
                System.out.print("请重新输入：");
                Scanner sc = new Scanner(System.in);
                setAge(sc.nextInt());
            }else {
//                do nothing
            }
        }
    }

//  必须存在构造方法，格式（没有返回值的类型，构造器的名字必须与类名一模一样）
//  作用：为了给以创建好的对象进行初始化。但是一般我们不会在空构造器中进行初始化

    public E62(){

    }

    public E62(String name,int age,E62_Gender sex){
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

class E62_Main{
    @Test
    public void Test(){
        E62 e1 = new E62();
        e1.setAge(10);
        e1.setName("nene");
        e1.setSex(E62_Gender.女);            //枚举调用方法，就是直接枚举名.成员名，如果成员名不存在枚举里面，程序会报错
        System.out.println(e1);

    }
}




