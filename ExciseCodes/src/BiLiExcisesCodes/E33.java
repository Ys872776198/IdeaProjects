package BiLiExcisesCodes;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: YS
 * @Date: 2021/6/30
 * @Description: TreeSet
 * @Version: 1.0
 */
//public class E33 implements Comparable<E33> {               //使用内部比较器
public class E33  {                     //使用外部比较器
    private int age;        //年龄
    private String name;    //姓名
    private double high;    //身高

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public E33(){

    };

    public E33(int age, String name, double high){
        this.setAge(age);
        this.setName(name);
        this.setHigh(high);
    };

    @Override
    public String toString() {
        return "E32{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", high=" + high +
                '}';
    }

//    内部比较器
//    @Override
//    public int compareTo(E33 o) {
////        return (this.getAge() - o.getAge());               //判断年龄
////        return (this.getName().compareTo(o.getName()));    //判断姓名
//        return (((Double)this.getHigh()).compareTo((Double)o.getHigh()));     //判断身高
//    }
}
//    外部比较器
class BiJioa2 implements Comparator<E33> {
    @Override
    public int compare(E33 o1, E33 o2) {
//        return (o1.getAge() - o2.getAge());               //判断年龄
//        return (o1.getName().compareTo(o2.getName()));    //判断姓名
        return (((Double)o1.getHigh()).compareTo((Double)o2.getHigh()));     //判断身高
    }
}

class E33_Main {
    public static void main(String[] args) {
//        输入Integer类型数据
//        TreeSet<Integer> t1 = new TreeSet<>();
////        默认的输出顺序为升序
//        t1.add(19);
//        t1.add(15);
//        t1.add(18);
//        t1.add(10);
//        t1.add(20);
//        t1.add(19);

//        输入String类型数据
//        TreeSet<String> t1 = new TreeSet<>();
////        默认的输出顺序为升序
//        t1.add("lila");
//        t1.add("lili");
//        t1.add("lilb");
//        t1.add("lild");
//        t1.add("lilc");
//        t1.add("lili");

//        放入自定义类型的数据
//        使用内部比较器
//        TreeSet<E33> t1 = new TreeSet<>();
//        t1.add(new E33(18, "lili", 166.8));
//        t1.add(new E33(19, "lili", 166.8));
//        t1.add(new E33(18, "lila", 166.8));
//        t1.add(new E33(18, "lilb", 166.8));
//        t1.add(new E33(18, "lili", 166.0));
//        t1.add(new E33(16, "lilc", 166.8));
//
//        System.out.println(t1.size());
//        System.out.println(t1);
//        System.out.println("--------------------------------");

//        使用外部比较器
//        创建一个外部比较器的对象
        Comparator<E33> com1 = new BiJioa2();
//        换个写法，利用匿名内部类
//        接口是无法创建对象的，但是可以利用匿名内部类来实现，如下
//        Comparator<E33> c2 = new Comparator<E33>() {
//            @Override
//            public int compare(E33 o1, E33 o2) {
//                return 0;
//            }
//        };

//        再换一个写法
//        TreeSet<E33> t1 = new TreeSet<>(new Comparator<E33>() {
//            @Override
//            public int compare(E33 o1, E33 o2) {
//                return 0;
//            }
//        }
//        );

//        将外部比较器指定给TreeSet,一旦指定了比较器，就会使用外部比较器
        TreeSet<E33> t1 = new TreeSet<>(com1);

        t1.add(new E33(18, "lili", 166.8));
        t1.add(new E33(19, "lili", 166.8));
        t1.add(new E33(18, "lila", 166.8));
        t1.add(new E33(18, "lilb", 166.8));
        t1.add(new E33(18, "lili", 166.0));
        t1.add(new E33(16, "lilc", 166.8));

        System.out.println(t1.size());
        System.out.println(t1);
        System.out.println("--------------------------------");

//        遍历
        Iterator<E33> i1 = t1.iterator();
        while (i1.hasNext()){
            System.out.println(i1.next());
        }

    }
}