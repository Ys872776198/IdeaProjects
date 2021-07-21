package BiLiExcisesCodes;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YS
 * @Date: 2021/6/19
 * @Description: 泛型（3）：泛型参数的继承关系与通配符"?"
 * @Version: 1.0
 */
public class E29 {

//    public void a(List<Object> l){
//
//    }
//
//    public void a(List<Integer> l){
//
//    }
//
//    public void a(List<String> l){
//
//    }

    public void a(List<?> l){

//        1、遍历的时候使用Object类型接受数据
        for(Object o : l){
            System.out.println(o);
        }

//        2、数据的写入                //不能随意写入，但是可以写入null
//        l.add("abc");             //报错，不能随意添加数据，因为不确定数据的类型
        l.add(null);

//        3、数据的读出               //可以读出，但是需要使用Object类型接受数据
        Object o = l.get(0);

    }

}

class Son_E29 extends E29{

}

class E29Main{
//        泛型参数的继承关系：A和B时子类父类的继承关系，但是G(A)和G(B)不存在继承关系，G(A)和G(B)是并列的
//    public static void main(String[] args) {
//        Object ob1 = new String();           //多态
//
//        Object[] ob2 = new String[10];       //多态
//
//        List<Object> l1 = new ArrayList<>();
//        List<String> l2 = new ArrayList<>();
////        l1 = l2;                           //报错
//    }

////        通配符“？”
////        A和B时子类父类的继承关系，但是G(A)和G(B)不存在继承关系，G(A)和G(B)是并列的
////        但是加入通配符“？”后，G(?)相当于G(A)和G(B)的父类
//    public static void main(String[] args) {
//////        三个集合为并列关系
////        List<Object> l1 = new ArrayList<>();
////        List<Integer> l2 = new ArrayList<>();
////        List<String> l3 = new ArrayList<>();
////
//////        List<?>相当于List<Object>, List<Integer>, List<String>的父类
////        List<?> l4 = new ArrayList<>();
////        l4 = l1;
////        l4 = l2;
////        l4 = l3;
//
//        E29 e1 = new E29();
//        e1.a(new ArrayList<Object>());
//        e1.a(new ArrayList<String>());
//        e1.a(new ArrayList<Integer>());
//    }

//        泛型受限
    public static void main(String[] args) {
//        l1, l2, l3三个集合是并列的关系
        List<Object> l1 = new ArrayList<>();
        List<E29> l2 = new ArrayList<>();
        List<Son_E29> l3 = new ArrayList<>();

//        开始泛型受限：泛型的上限
//        <? extends E29>代表泛型参数类型必须是E29或者E29的子类才能接收数据
        List<? extends E29 > l4 = new ArrayList<>();
//        l4 = l1;        //不行，Object是E29的父类
        l4 = l2;        //可以
        l4 = l3;        //可以

//        开始泛型受限：泛型的下限
//        <? super E29>代表泛型参数类型必须是E29或者E29的父类才能接收数据
        List<? super E29> l5 = new ArrayList<>();
        l5 = l1;        //可以
        l5 = l2;        //可以
//        l5 = l3;        //不行，Son_E29是E29的子类

    }



}