package BiLiExcisesCodes;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2021/7/11
 * @Description: IO流(访问文件: DataInputStream和DataOutputStream(数据流，处理流)(用来操作基本数据类型和字符串))
 * @Version: 1.0
 */
public class E44 {
    public static void main(String[] args) throws IOException {
//        DataOutputStream：将内存中的基本数据类型和字符串写入到文件中
//            1、创建目标文件对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                    File.separator + "ExciseFiles" +  File.separator + "4.txt");

//            2、将目标文件与输出流链接
//                创建字节输出流对象,链接目标文件对象
        FileOutputStream fos = new FileOutputStream(f1);
//                创建数据输出流对象，链接字节输出流对象
        DataOutputStream dos = new DataOutputStream(fos);

//            3、完成输出操作(在目标文件里面生成的数据是提供给机器看的,看不懂很正常)
        dos.writeInt(1903);
        dos.writeChar('d');
        dos.writeBoolean(true);
        dos.writeDouble(1749817489l);
        dos.writeByte(-128);              //byte取值范围 -128~127
        dos.writeUTF("wdadwada");



//        DataInputStream：将文件中的基本数据类型和字符串写入到内存中
//            4、将目标文件与输入流链接
//                创建字节输入流对象，链接目标文件对象
        FileInputStream fis = new FileInputStream(f1);
//                创建数据输入流对象，连接字节输入流对象
        DataInputStream dis = new DataInputStream(fis);

//            5、完成读入文件(读入的顺序必须与写入的顺序一致，否则会出现乱码)
        System.out.println(dis.readInt());
        System.out.println(dis.readChar());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readDouble());
        System.out.println(dis.readByte());
        System.out.println(dis.readUTF());


//            6、关闭流(关闭外层高级流)
        dis.close();
        dos.close();

    }
}
