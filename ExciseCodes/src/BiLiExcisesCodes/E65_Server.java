package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/28
 * @Description: 网络编程（TCP）
 * @Version: 1.0
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 注意：
 * 1、IP不行就换成localhost
 * 2、必须先启动服务器，在启动客户端
 * 3、不能重复启动服务器（重复启动会出现端口号冲突）
 */

//案例：利用账号密码登录，判断是否登陆成功
//    服务器端
public class E65_Server {
    public static void main(String[] args) throws Exception {
        System.out.println("!---------服务器启动--------!");
//        1、服务器端先创建一个套接字，指定本侧的端口号：（利用的类是ServerSocket类）
        ServerSocket ss = new ServerSocket(8070);       //指定端口号
//        2、同过ServerSocket类的accept()方法获取服务器端的套接字
        Socket s = ss.accept();                             //阻塞方法
//        3、对于服务器端来说，我需要输入流来获取客户端发送内容
        InputStream is = s.getInputStream();        //InputStream是字节输入类的抽象基础类

        ObjectInputStream ois = new ObjectInputStream(is);
        User user = (User)ois.readObject();

//        给客户点发送消息
//            先关闭输入流
        s.shutdownInput();
//            再开启输出流
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        if((user.getUsername().equals("nene")) && (user.getPassword().equals("123456"))){
            dos.writeUTF("登录成功");
        }else{
            dos.writeUTF("登录失败");
        }

//        4、关闭流，后开先关
        dos.close();        //关闭高级流
        ois.close();        //关闭高级流，即可
        s.close();          //关闭服务器套接字
        ss.close();         //关闭服务器套接字
    }
}
