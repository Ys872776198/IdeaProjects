package BiLiExcisesCodes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: YS
 * @Date: 2021/7/27
 * @Description: 网络编程（TCP）（双向通信）
 * @Version: 1.0
 */

/**
 * 注意：
 * 1、IP不行就换成localhost
 * 2、必须先启动服务器，在启动客户端
 * 3、不能重复启动服务器（重复启动会出现端口号冲突）
 */

//案例：利用账号密码登录，判断是否登陆成功
//    服务器端
public class E63_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("!---------服务器启动--------!");
//        1、服务器端先创建一个套接字，指定本侧的端口号：（利用的类是ServerSocket类）
        ServerSocket ss = new ServerSocket(8070);       //指定端口号
//        2、同过ServerSocket类的accept()方法获取服务器端的套接字
        Socket s = ss.accept();                             //阻塞方法
//        3、对于服务器端来说，我需要输入流来获取客户端发送内容
        InputStream is = s.getInputStream();        //InputStream是字节输入类的抽象基础类
        DataInputStream dis = new DataInputStream(is);      //DataInputStream是数据流，处理流，用来操作基本数据类型和字符(参考E44)
                                                            //DataInputStream：将文件中的基本数据类型和字符串写入到内存中

//        接收客户端发过来的信息
        System.out.println("客户端对我说：" + dis.readUTF());

//        给客户点发送消息
//            先关闭输入流
        s.shutdownInput();
//            再开启输出流
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("你好，我是服务器！");

//        4、关闭流，后开先关
        dos.close();        //关闭高级流
        dis.close();        //关闭高级流，即可
        s.close();          //关闭服务器套接字
        ss.close();         //关闭服务器套接字
    }
}
