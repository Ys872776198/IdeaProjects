package BiLiExcisesCodes;

import java.util.Comparator;

/**
 * @Auther: YS
 * @Date: 2021/6/28
 * @Description: 比较器
 * @Version: 1.0
 */
public class E32 implements Comparable<E32>{

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

    public E32(){

    };

    public E32(int age, String name, double high){
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
//    内部比较器要继承接口Comparable
//    并且要重写CompareTo方法
    @Override
    public int compareTo(E32 o) {
        if((this.getAge() - o.getAge()) == 0){                  //先比较年龄，年龄相同比较姓名
            if((this.getName().compareTo(o.getName())) == 0){   //在比较姓名，姓名相同比较身高
                if(((Double)this.getHigh()).compareTo((Double)o.getHigh()) == 0){   //最后比较身高
                    return 0;
                }else {
                    System.out.print("身高：");
                    return ((Double)this.getHigh()).compareTo((Double)o.getHigh());
                }
            }else{
                System.out.print("姓名：");
                return (this.getName().compareTo(o.getName()));
            }
        }else{
            System.out.print("年龄：");
            return (this.getAge() - o.getAge());
        }
    }
}

//    外部比较器
//    外部比较器要继承接口Comparator
//    并且要重写CompareTo方法
class Bijiao implements Comparator<E32> {
    @Override
    public int compare(E32 o1, E32 o2) {
        if((o1.getAge() - o2.getAge()) == 0){                  //先比较年龄，年龄相同比较姓名
            if((o1.getName().compareTo(o2.getName())) == 0){   //在比较姓名，姓名相同比较身高
                if(((Double)o1.getHigh()).compareTo((Double)o2.getHigh()) == 0){   //最后比较身高
                    return 0;
                }else {
                    System.out.print("身高：");
                    return ((Double)o1.getHigh()).compareTo((Double)o2.getHigh());
                }
            }else{
                System.out.print("姓名：");
                return (o1.getName().compareTo(o2.getName()));
            }
        }else{
            System.out.print("年龄：");
            return (o1.getAge() - o2.getAge());
        }
    }
}


class E32_Main {
    public static void main(String[] args) {

//        数据比较：做差值，返回值为int类型
//        int类型的数据比较:两数相减
//        int i1 = 10;
//        int i2 = 20;
//        System.out.println(i1 - i2);

//        String类型的数据进行比较：调用String里面的CompareTo方法
//        String s1 = "haha";
//        String s2 = "hahv";
//        System.out.println(s1.compareTo(s2));

//        double类型的数据进行比较：自动装箱为Double,然后调用compareTo方法
//        double d1 = 28901479.132;
//        double d2 = 74982794729.3242;
//        System.out.println(((Double) (d1)).compareTo((Double) (d2)));

//        自定义的数据进行比较
        E32 e1 = new E32(18, "lili", 166.8);
        E32 e2 = new E32(18, "lila", 166.7);

//        使内部比较器
//        System.out.println(e1.compareTo(e2));

//        使用外部比较器
        Bijiao b1 = new Bijiao();
        System.out.println(b1.compare(e1, e2));

    }
}