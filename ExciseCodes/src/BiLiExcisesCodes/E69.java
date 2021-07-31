package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/29
 * @Description: 反射
 * @Version: 1.0
 */
public class E69 {
    public static void main(String[] args) throws ClassNotFoundException {
//        获取字节码信息的四种方式(以E69_Person为例)
//        方法1、通过gatClass方法获取(不常用，已经有对象产生，可以直接利用对象来调用属性和方法)
        E69_Person e1 = new E69_Person();       //先要存在一个具体的对象
        Class c1 = e1.getClass();               //利用gatClass方法获取的就是字节码信息的具体的Class对象
        System.out.println(c1);

//        方法2、直接利用类里面只带的class属性(不常用，已经有对象产生，可以直接利用对象来调用属性和方法)
        Class c2 = E69_Person.class;            //利用类的内置class属性
        System.out.println(c2);

        System.out.println((c1 == c2));         //true，字节码信息只被加载一次

//        方法3、利用Class里面的forName(全限定路径)方法(常用)
        Class c3 = Class.forName("BiLiExcisesCodes.E69");
        System.out.println(c3);

//        方法4、利用类的加载器（属于了解范围的技能点）
        ClassLoader cl = E69.class.getClassLoader();
        Class c4 = cl.loadClass("BiLiExcisesCodes.E69");

        System.out.println((c3 == c4));
    }

}
