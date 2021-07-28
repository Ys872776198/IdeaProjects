package BiLiExcisesCodes;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/7/28
 * @Description: 网络编程（TCP）
 * @Version: 1.0
 */
//案例：利用账号密码登录，判断是否登陆成功
//    客户端
public class E65_Client {
    public static void main(String[] args) throws IOException {
        System.out.println("!---------客户端启动--------!");
//        1、创建客户端的套接字，并且指定服务器的IP地址和端口号(利用Socket类)
        Socket s = new Socket("localhost", 8070);
//        2、对于客户端来说，利用输出流想服务器端发送数据
        OutputStream os = s.getOutputStream();                  //OutputStream是字节输出类的抽象基础类
        ObjectOutputStream oos = new ObjectOutputStream(os);

        Scanner sc = new Scanner(System.in);
        System.out.print("账号：");
        String username = sc.next();
        System.out.print("密码：");
        String password = sc.next();

        User user = new User(username, password);
        oos.writeObject(user);

//        获取服务器的信息
//            先关闭输出流
        s.shutdownOutput();
//            在开启输入流
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println("服务端回复：" + dis.readUTF());

//        3、关闭流，后开先关
        dis.close();        //关闭高级流
        oos.close();        //关闭高级流，即可
        s.close();          //关闭服务器套接字
    }
}
