package BiLiExcisesCodes;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @Auther: YS
 * @Date: 2021/6/23
 * @Description: HashSet
 * @Version: 1.0
 */
public class E31 {
    public static void main(String[] args) {
//        HashSet的特点是唯一，无序。但是如果想要根据输入的顺序来输出。可以选择LinkedHashSet实现类，该类在哈希表的外面增加了一个总链表，将输入的信息串在一起
//        创建一个HashSet集合
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<String> hs2 = new HashSet<>();
        HashSet<E31_Student> hs3 = new HashSet<>();

//        创建一个LinkedHashSet集合
//        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
//
//        System.out.println(lhs.add(18));
//        lhs.add(16);
//        lhs.add(17);
//        System.out.println(lhs.add(18));
//        lhs.add(19);
//        lhs.add(120);
//        lhs.add(8);
//
//        System.out.println(lhs.size());
//        System.out.println(lhs);                //输出的顺序按照输入的顺序体现
//        System.out.println("------------------------------------------");

//        添加Integer类型数据
//        System.out.println(hs1.add(18));
//        hs1.add(16);
//        hs1.add(17);
//        System.out.println(hs1.add(18));        //会调用系统自带的equals方法，当数值相同时，后者无法放入哈希表中
//        hs1.add(19);
//        hs1.add(120);
//        hs1.add(8);
//
//        System.out.println(hs1.size());
//        System.out.println(hs1);
//        System.out.println("------------------------------------------");

//        添加String类型数据
//        hs2.add("abc");
//        hs2.add("abd");
//        hs2.add("adc");
//        hs2.add("abc");
//        hs2.add("abb");
//        hs2.add("aac");
//
//        System.out.println(hs2.size());
//        System.out.println(hs2);
//        System.out.println("------------------------------------------");

//        添加自定义的数据类型
//              类中要重写ToString方法，HashSet会调用，否则出现哈希值
//              如果类中不重写equlas方法和HashCode方法，那么系统无法判断数据是否相等和计算具体的存放位置
//              equlas方法和HashCode方法对于哈希表来说很重要
//              重写equlas方法和HashCode方法后，系统会自动识别相同的数据
        hs3.add(new E31_Student("lili", 19));
        hs3.add(new E31_Student("lili", 19));
        hs3.add(new E31_Student("lili", 16));
        hs3.add(new E31_Student("bili", 19));
        hs3.add(new E31_Student("cili", 19));
        hs3.add(new E31_Student("hili", 19));

        System.out.println(hs3.size());
        System.out.println(hs3);
        System.out.println("------------------------------------------");

    }

}

class E31_Student{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public E31_Student(){

    }

    public E31_Student(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String toString() {
        return "E31_Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    添加HashCode方法和Equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E31_Student that = (E31_Student) o;
        return age == that.age &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}