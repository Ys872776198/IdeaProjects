package BiLiExcisesCodes;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/7/27
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */

//案例：利用账号密码登录，判断是否登陆成功
//    客户端
public class E64_Client {
    public static void main(String[] args) {
        System.out.println("!---------客户端启动--------!");
//        创建客户端套接字，链接服务器
        Socket s = null;            //变量初始化
        OutputStream os = null;
        ObjectOutputStream oos = null;
        InputStream is = null;
        DataInputStream dis = null;

        try {
            s = new Socket("localhost", 8070);

//            录入账号和密码
            Scanner sc = new Scanner(System.in);
            System.out.print("账号：");
            String username = sc.next();
            System.out.print("密码：");
            String password = sc.next();

            User user = new User(username, password);

//            输出用户信息
            os = s.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(user);

//            接收服务器端的信息反馈
            s.shutdownOutput();
            is = s.getInputStream();
            dis = new DataInputStream(is);
            System.out.println("登录结果：" + dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(dis != null){
                    dis.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(oos != null){
                    oos.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(s != null){
                    s.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
