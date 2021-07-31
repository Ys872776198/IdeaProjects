package BiLiExcisesCodes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @Auther: YS
 * @Date: 2021/7/30
 * @Description: 反射（获取属性和对属性赋值）
 * @Version: 1.0
 */
public class E72 {
    public static void main(String[] args) throws Exception {
//        获取运行时类的字节码信息
//            利用Class类的forName方法(静态方法),获取Class的实例（即获取E69_Student类的字节码信息）
        Class c1 = Class.forName("BiLiExcisesCodes.E69_Student");

//        获取属性（public修饰的属性）
        Field[] f1 = c1.getFields();                             //getFields()方法返回的时public修饰的属性，且是public修饰的属性组成的数组
        for (Field f : f1){
            System.out.println("返回的是public修饰的属性:" + f);     //将父类中被public修饰的属性也获取到了
        }
//        获取属性（任意修饰符修饰的属性）
        Field[] f2 = c1.getDeclaredFields();                     //getDeclaredFields()方法返回的时任意修饰符修饰的属性，且是任意修饰符修饰的属性组成的数组
        for (Field f : f2){
            System.out.println("返回的是任意修饰符修饰的属性:" + f);   //这里获取的是 当前类 所有的属性，没显示父类的属性
        }

//        获取指定的属性（public修饰的属性）
        Field f3 = c1.getField("classroom");  //c1.getField()方法可以获取指定的属性，但是这个属性是被public修饰的
        System.out.println("Classroom：" + f3);
//        获取指定的属性（任意修饰符修饰的属性）
        Field f4 = c1.getDeclaredField("sex");  //c1.getField()方法可以获取指定的属性，但是这个属性是被任意修饰符修饰的
        System.out.println("Sex：" + f4);

//        获取属性的具体结构
//            获取属性的修饰符
        int m = f4.getModifiers();                     //利用getModifiers()方法可以获取属性的修饰符，但是返回的是Int型的数值，无论什么属性都可以用这个方法获取属性的修饰符
                                                       //这是因为在Modifier类里面将修饰符用来对应的数字来表示（可见Modifier类的内部）
                                                       //如果属性有多个修饰符修饰，例 protected static 。。。等，那么返回值就是两个修饰符对应数值的和，例：0x00000004 + 0x00000008 = 0x0000000C(16进制)
        System.out.println("数值：" + m);
        System.out.println("属性的修饰符：" + Modifier.toString(m));      //利用 Modifier类的toString()方法，将Int型数据还原成属性的修饰符（toString()方法为静态方法，且有入参，入参为Int型数据）

//            获取属性的数据类型
        Class t1 = f4.getType();                       //利用getType()方法，返回的是Class对象，因为不管什么类型都可以是Class类下的对象
        System.out.println(t1.getName());              //利用Class类的getName()方法获取数据类型，无论什么属性都可以用这个方法获取属性的数据类型

//            获取属性的姓名
        String name1 = f4.getName();                   //利用getName方法获取指定属性的姓名，无论什么属性都可以用这个方法获取属性名
        System.out.println(name1);


//        对属性赋值（除被private修饰的属性外，都可以用这个方法进行赋值 ）
        Constructor ct = c1.getConstructor();       //获取空构造器，利用控空构造器创建对象
        Object o = ct.newInstance();                //创建对象

        Field f5 = c1.getField("classroom");
        f4.set(o,"男");                              //set()方法的入参有两个，一个是对象，一个是属性值，即对指定对象的指定属性进行赋值（也可以对static修饰的属性赋值）
        System.out.println("Classroom：" + o);       //想要查看属性是否赋值成功，直接将对象输出即可

        Field f6 = c1.getDeclaredField("sno");
        f6.setAccessible(true);                     //想要调用private修饰的属性,要将此 属性 的 accessible 标志设置为指示的布尔值。
                                                    // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查
        f6.set(o, "423423");
        System.out.println(o);

    }
}
