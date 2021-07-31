package BiLiExcisesCodes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: YS
 * @Date: 2021/7/30
 * @Description: 反射（获取构造器和创建对象）
 * @Version: 1.0
 */
public class E71 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        获取运行时类的字节码信息
//            利用Class类的forName方法(静态方法),获取Class的实例（即获取E69_Student类的字节码信息）
        Class c1 = Class.forName("BiLiExcisesCodes.E69_Student");

//        通过字节码信息获取构造器（public修饰的构造器）
//        Constructor[] ct1 = c1.getConstructors();        //getConstructors()方法只能返回public修饰的构造器，且返回的是以public修饰的构造方法组成的数组
//        for(Constructor c : ct1){
//            System.out.println("返回的是public修饰的构造器:" + c);
//        }
//        通过字节码信息获取构造器（任意修饰符修饰的构造器）
//        Constructor[] ct2 = c1.getDeclaredConstructors();//getDeclaredConstructors()方法可以返回任意修饰符修饰的构造器，且返回的是构造器组成的数组
//        for(Constructor c : ct2){
//            System.out.println("返回的是任意修饰符修饰的构造器:" + c);
//        }

//        获取指定的构造器（public修饰的构造器）
        Constructor ct3 = c1.getConstructor();            //getConstructor()方法可以返回指定的被public修饰的构造器，这个方法的入参是可变参数，通过输入参数来选择对应的构造器
        System.out.println("返回的是public修饰的构造器:" + ct3);//因为c1.getConstructor()没有添加入参，那么返回的就是，public修饰的空构造器

        Constructor ct4 = c1.getConstructor(String.class, int.class, String.class, String.class);//入参必须是Class的实例，且是和选择的构造器入参的数据类型对应的Class对象
        System.out.println("返回的是public修饰的构造器:" + ct4);//通过入参的类型，数量，排序来选择public修饰的构造器
//        获取指定的构造器（任意修饰符修饰的构造器）
        Constructor ct5 = c1.getDeclaredConstructor(String.class);//getDeclaredConstructor()方法返回的是任意修饰符修饰的构造器，这个方法的入参是可变参数，通过输入参数来选择对应的构造器
        System.out.println("返回的是任意修饰符修饰修饰的构造器:" + ct5); //通过入参的类型，数量，排序选择任意修饰符修饰的构造器

//        获取了构造器就可以实例化对象
        Object o = ct3.newInstance();                   //获取的构造器利用newInstance()方法来实例化对象,这个方法的入参是可变参数，通过输入参数来选择对应的构造器来实例化对象
        System.out.println("利用空构造器来创建对象：" + o);

        Object o1 = ct4.newInstance("2318103", 99, "男", "426");//newInstance()方法的入参必须和所选择的构造器入参的数据类型对应，且是具体数据（属性值）而不是Class对象，这些数据会直接赋给对应的属性
        System.out.println("利用有参构造器来创建对象：" + o1);

        ct5.setAccessible(true);                        //想要调用private修饰的构造器,要将此 构造器 的 accessible 标志设置为指示的布尔值。
                                                        // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查
        Object o2 = ct5.newInstance("dawda");
        System.out.println("利用有参构造器来创建对象(private)：" + o2);
    }
}
