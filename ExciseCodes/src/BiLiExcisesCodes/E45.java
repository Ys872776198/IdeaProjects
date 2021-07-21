package BiLiExcisesCodes;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2021/7/12
 * @Description: IO流(访问文件: ObjectInputStream和ObjectOutputStream(对象流，处理流)(用来操作基本数据类型和对象))
 * @Version: 1.0
 */
public class E45 implements Serializable {
//    Serializable接口是个空接口，这是一个标识接口（类似于出入证）
//    实现这个接口就代表这个自定义类以及实现了序列化
//    private static final long serialVersionUID = 782794729l;
    private static final long serialVersionUID = -7948398947452818405L;
    private int age;
    private String Name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public E45() {
    }

    public E45(int age, String name) {
        this.age = age;
        this.Name = name;
    }

    @Override
    public String toString() {
        return "E45{" +
                "age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }
}

//序列化时将E45这个对象写入到文件当中，也就是说写入到文件当中的E45类是没有toSring方法的
//但是序列化之后加入了toString方法，在进行反序列化时，读经来的对象是不带toString方法的，因此导致两个类不匹配，因此会报错InvalidClassException
//解决办法：给类价格序列号(private static final long serialVersionUID = 782794729l;)。作用表明类不同版本间的兼容性

/*
细节：1、IDEA中配置序列号：Setting-》Inspections-》搜索seri，选择Serialization issues里面的Externalizable class without 'serialVersionUID'
       配置完成后，直接在类名处使用alt+enter组合键
     2、被序列化的类的内部所有属性，必须是可序列化，即使属性中有自定义的类，该类也必须实现Serializable接口。基本数据类型都可序列化。
     3、Static，transient修饰的属性，不可被序列化

 */

class E45_Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ObjectOutputStream：将内存中基本数据类型或者对象写入到文件当中(序列化：将Java对象转换成平台无关的二进制数据)
//            1、创建目标文件对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "4.txt");

//            2、将目标文件和输出流链接
//                创建字符输出流对象，链接源文件对象
        FileOutputStream fos = new FileOutputStream(f1);
//                创建对象输出流对象，链接字符输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(fos);

//            3、完成输出功能（在目标文件里面生成的数据是提供给机器看的,看不懂很正常）
//        oos.writeObject("Hello wrold");     //写入字符串
        E45 e = new E45(19, "nene");
        oos.writeObject(e);                   //在自定义类中没有实现Serializable接口，报错NotSerializableException（没有序列化）
                                              //解决办法：实现Serializable接口，但是Serializable接口是个空接口，这是一个标识接口（类似于出入证）


//        ObjectInputStream：将文件中的基本数据类型或者对象写入到内存当中(反序列化：将平台无关的二进制数据转换成Java对象)
//            4、将目标文件和输入流链接
//                创建字符输入流对象，链接源文件对象
        FileInputStream fis = new FileInputStream(f1);
//                创建对象输出流对象，链接字符输出流对象
        ObjectInputStream ois = new ObjectInputStream(fis);

//            5、完成读入功能
//        Object o = ois.readObject();
        E45 o = (E45)ois.readObject();
        System.out.println(o);

//            6、关闭流(关闭外层高级流)
        ois.close();
        oos.close();








    }
}