package BiLiExcisesCodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * @Auther: YS
 * @Date: 2021/6/17
 * @Description: 泛型（1）
 * @Version: 1.0
 */

/*
E27是一个普通类
E27<A>是一个泛型类
<>里面就是一个不确定的参数类型，需要要实例化对象时确定
A代表的是引用数据类型，而不是基本数据类型
泛型可以定义多个参数类型public class E27<A, B, C>
在类的构造器当中，不能添加参数类型，如：public E27<A, B, C>(){}
不同泛型的引用类型不可以相互赋值,如:ArrayList<String> l1 = new ArrayList<>();    ArrayList<Integer> l2 =new ArrayList<>();   l1 = l2;
泛型类不能被static修饰，因为Static先于对象存在
不能使用A[]创建数组，如：
  A[] i1 = new A[9];                //错
  A[] i2 = (A[]) new Object[10];    //对

 */
public class E27<A> {
    private int age;
    private A name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public A getName() {
        return name;
    }

    public void setName(A name) {
        this.name = name;
    }

    public void show1(A a){

    }

    public void show1(A[] a){

    }

    public E27(){}

}

class S_E27_1 extends E27<String>{
    public S_E27_1(){}
}
class S_E27_2<E> extends E27<E>{
    public S_E27_2(){}
}

class E27Main{

//    1、泛型的引入
//    public static void main(String[] args) {
//        ArrayList<Integer> a1 = new ArrayList<>();
//        a1.add(19);
//        a1.add(17);
//        a1.add(15);
////        a1.add(19.2);
////        a1.add("abc");
//
//        for(Integer i : a1){
//            System.out.println(i);
//        }
//
//
//    }

//    2、泛型类
    public static void main(String[] args) {
//        泛型类实例化时，不指出具体的数据类型时，所有数据类型都默认Object类型
//        E27 e1 = new E27();
//        e1.show1(19);
//        e1.show1("abs");
//        e1.show1(new String[]{"haha", "and"});
//        e1.show1(new int[]{1, 2, 3});

//        泛型类实例化时，指出具体的数据类型时，所有数据必须是指定的数据类型
//        E27<String> e1 = new E27();
////        e1.show1(19);
//        e1.show1("abs");
//        e1.show1(new String[]{"haha", "and"});
////        e1.show1(new int[]{1, 2, 3});
//        e1.setName("nene");
//        System.out.println(e1.getName());

//        在继承中，如果父类指定了数据类型，那么子类直接使用即可（S_E271）
//        S_E27_1 s1 = new S_E27_1();
//        s1.setName("nene");
//        System.out.println(s1.getName());
//
//        s1.show1("and");
//        s1.show1(new String[]{"haha", "and"});

//        在继承中，如果父类没有指定数据类型，那么子类也需要加上没有明确具体数据类型的标记符（S_E272）
//            子类在实例化时，不明确具体的数据类型，因此所有的数据类型默认为Object类型
//        S_E27_2 s2 = new S_E27_2();
//        s2.setName(213);
//        s2.show1(312);
//        s2.show1(new String[]{"haha", "and"});
//        System.out.println(s2.getName());

//            子类在实例化时，明确具体的数据类型，因此所有的数据必须为指定的数据类型
//        S_E27_2<String> s2 = new S_E27_2();
//        s2.setName("nene2");
////        s2.setName(213);
//        s2.show1("haha");
////        s2.show1(312);
//        s2.show1(new String[]{"haha", "and"});
//        System.out.println(s2.getName());



    }

}