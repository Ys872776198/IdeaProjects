package BiLiExcisesCodes;

import java.util.Comparator;

/**
 * @Auther: YS
 * @Date: 2021/7/30
 * @Description: 反射(Class类)
 * @Version: 1.0
 */
public class E70 {
    public static void main(String[] args) {
        /**
         * Class类的具体实例（Class类的具体对象，就是对应数据类型的字节码信息，即那些数据类型能生成字节码信息，只要能存放到内存当中就可以生产字节码文件）
         * 1、类：外部类，内部类
         * 2、接口
         * 3、数组
         * 4、注解
         * 5、基本数据类型
         * 6、void
         */

//        验证
//        1、类
        Class c1 = E69_Person.class;
        System.out.println(c1);

//        2、接口
        Class c2 = Comparator.class;
        System.out.println(c2);

//        3、数组(利用getClass方法获取)
        int[] i1 = {1,2,3};
        int[] i2 = {4,5,6};
        Class c3_i1 = i1.getClass();
        Class c3_i2 = i1.getClass();
        System.out.println(c3_i1);
        System.out.println(c3_i2);

        System.out.println((c3_i1 == c3_i2));       //true  同维度，同类型得到的字节码信息是同一个

//        4、注解
        Class c4 = Override.class;
        System.out.println(c4);

//        5、基本数据类型
        Class c5 = int.class;
        System.out.println(c5);

//        6、void
        Class c6 = void.class;
        System.out.println(c6);

    }
}
