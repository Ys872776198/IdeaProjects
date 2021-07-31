package BiLiExcisesCodes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Auther: YS
 * @Date: 2021/7/31
 * @Description: 反射（获取方法和调用方法）
 * @Version: 1.0
 */
public class E73 {
    public static void main(String[] args) throws Exception {
//        获取运行时类的字节码信息
//            利用Class类的forName方法(静态方法),获取Class的实例（即获取E69_Student类的字节码信息）
        Class c1 = Class.forName("BiLiExcisesCodes.E69_Student");

//        获取方法（public修饰的方法）
        Method[] m1 = c1.getMethods();                      //利用getMethods()方法返回的是被Public修饰的方法组成的数组，且会获取父类中的被Public修饰的方法
        for(Method m : m1){
            System.out.println("public修饰的方法：" + m);     //被static修饰的方法也会被显示
        }
//        获取方法(任意修饰符修饰的方法)
        Method[] m2 = c1.getDeclaredMethods();             //利用getDeclaredMethods()方法的是当前类的所有方法，不会显示父类的方法
        for(Method m : m2){
            System.out.println("任意修饰符修饰的方法：" + m);  //被static修饰的方法也会被显示
        }

//        获取指定的方法（public修饰的方法）
        Method m3 = c1.getMethod("fly");           //getMethod()方法返回的是被public修饰的指定的方法
        System.out.println("public修饰的方法：" + m3);
        Method m4 = c1.getMethod("Division", int.class, int.class);     //也能返回被static修饰的，有参的，被public修饰的方法
        System.out.println("public修饰的方法：" + m4);
//        获取指定的方法（任意修饰符修饰的方法）
        Method m5 = c1.getDeclaredMethod("Look");                       //c1.getDeclaredMethod方法返回的是被任意修饰符修饰的指定的方法
        System.out.println("任意修饰符修饰的方法：" + m5);
        Method m6 = c1.getDeclaredMethod("Drink", String.class);        //也能返回被static修饰的，有参的，被任意修饰符修饰的方法
        System.out.println("任意修饰符修饰的方法：" + m6);

//        获取指定方法的返回值类型
        Class rt = m4.getReturnType();                                          //getReturnType()方法可以获取指定方法的返回值类型，这个方法无论被什么修饰的方法都可以用
        System.out.println("返回值类型：" + rt.getName());

//        获取指定方法的修饰符
        Class ac = m5.getClass();       //利用getModifiers()方法可以获取方法的修饰符，但是返回的是Int型的数值，无论什么方法都可以用这个方法获取方法的修饰符
                                        //这是因为在Modifier类里面将修饰符用来对应的数字来表示（可见Modifier类的内部）
                                        //如果方法有多个修饰符修饰，例 protected static 。。。等，那么返回值就是两个修饰符对应数值的和，例：0x00000004 + 0x00000008 = 0x0000000C(16进制)
        int i = ac.getModifiers();
        System.out.println(Modifier.toString(i));

//        获取属性的名字
        System.out.println(m5.getName());               //无论什么方法都可以用这个方法获取方法的名字

//        获取参数列表
        Class[] pt = m4.getParameterTypes();            //利用getParameterTypes()方法，可以获取指定方法的参数列表
        for(Class c : pt){                              //无论什么方法都可以用这个方法获取方法的参数列表
            System.out.println("参数列表：" + c);
        }

//        获取方法的注解
        Annotation[] att = m3.getAnnotations();     //利用getAnnotations()方法，可以获取方法的注解
        for(Annotation a : att){                    //但是在注解中如果有元注解是：RetentionPolicy.SOURCE。其中SOURCE代表编译时期进行校验，因此运行中的代码无法获取这个注解，将 SOURCE -> RUNTIME，就可以获取
            System.out.println("方法的注解：" + a);   //无论什么方法都可以用这个方法获取方法的注解
        }

//        获取方法的异常
        Class[] et = m6.getExceptionTypes();        //利用getExceptionTypes()方法，可以获取方法的异常
        for(Class c : et){
            System.out.println("方法的异常：" + c);   //无论什么方法都可以用这个方法获取方法的注解
        }

//        调用方法
        Object o = c1.newInstance();
//        m5.invoke(o);                 //利用invoke()方法调用指定对象的指定方法，invoke()方法第一个入参为具体的对象，第二个为可变参数，看指定的方法是否有入参，根据入参填写数值
        System.out.println(m4.invoke(o, 30, 3));    //第一个参数为具体的对象，不能忘了。可以调用被static修饰的方法

        Method m7 = c1.getMethod("setSno", String.class);
        Class<?> rt2 = m7.getReturnType();
        System.out.println(rt2);
        System.out.println(o);
        m7.invoke(o,"729742370");
        System.out.println(o);

        m5.setAccessible(true);             //想要调用private修饰的方法,要将此 方法 的 accessible 标志设置为指示的布尔值。
                                            // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查
        m5.invoke(o);

    }
}
