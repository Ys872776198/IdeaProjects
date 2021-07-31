package BiLiExcisesCodes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: YS
 * @Date: 2021/7/31
 * @Description: 反射（获取类的接口，所在包，注解）
 * @Version: 1.0
 */
public class E74 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        获取运行时类的字节码信息
//            利用Class类的forName方法(静态方法),获取Class的实例（即获取E69_Student类的字节码信息）
        Class c1 = Class.forName("BiLiExcisesCodes.E69_Student");
//        创建类的实例
//        Constructor con = c1.getConstructor();        //获取空构造器
//        Object o = con.newInstance();                 //利用空构造创建对象

        Object o = c1.newInstance();                    //这里默认的是利用空构造器创建对象，如果类里面没有空构造器，那么这个方法会报错（NoSuchMethodException）


//        获取运行时类的接口
        Class[] if1 = c1.getInterfaces();
        for(Class c : if1){
            System.out.println("运行时类的接口：" + c);
        }

//        得到父类的接口
//            获取父类字节码信息
//        Class c2 = Class.forName("BiLiExcisesCodes.E69_Person");
        Class c2 = c1.getSuperclass();                  //利用getSuperclass()方法，可以获取当前类的父类的字节码信息

        Class[] if2 = c2.getInterfaces();               //得到接口
        for(Class c : if2){
            System.out.println("父类运行时类的接口：" + c);
        }

//        获取运行时类所在的包
        Package ap = c1.getPackage();
        System.out.println("类所在的包：" + ap);          //返回的是这个包的全限定路径
        System.out.println("类所在的包：" + ap.getName());//返回的是包名

//        获取运行时类的注解
        Annotation[] at = c1.getAnnotations();
        for(Annotation a : at){
            System.out.println("运行时类的注解：" + a);
        }

    }
}
