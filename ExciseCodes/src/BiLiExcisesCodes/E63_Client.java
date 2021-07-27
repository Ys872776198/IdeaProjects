package BiLiExcisesCodes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther: YS
 * @Date: 2021/7/27
 * @Description: 网络编程（TCP）
 * @Version: 1.0
 */

/**
 * 注意：
 * 1、IP不行就换成localhost
 * 2、必须先启动服务器，在启动客户端
 * 3、不能重复启动服务器（重复启动会出现端口号冲突）
 */

//案例：利用账号密码登录，判断是否登陆成功
//    客户端
public class E63_Client {
    public static void main(String[] args) throws IOException {
        System.out.println("!---------客户端启动--------!");
//        1、创建客户端的套接字，并且指定服务器的IP地址和端口号(利用Socket类)
        Socket s = new Socket("localhost", 8070);
//        2、对于客户端来说，利用输出流想服务器端发送数据
        OutputStream os = s.getOutputStream();                  //OutputStream是字节输出类的抽象基础类
        DataOutputStream dos = new DataOutputStream(os);        //DataOutputStream是数据流，处理流，用来操作基本数据类型和字符(参考E44)
                                                                //DataOutputStream：将内存中的基本数据类型和字符串写入到文件中
        dos.writeUTF("hello, 我是客户端");                    //写入数据

//        3、关闭流，后开先关
        dos.close();        //关闭高级流，即可
        s.close();          //关闭服务器套接字
    }
}
