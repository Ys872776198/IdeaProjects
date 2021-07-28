package BiLiExcisesCodes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: YS
 * @Date: 2021/7/27
 * @Description: 网络编程（TCP）
 * @Version: 1.0
 */

//案例：利用账号密码登录，判断是否登陆成功
//    服务器端
public class E64_Server {
    public static void main(String[] args) {
        System.out.println("!---------服务器启动--------!");
        ServerSocket ss = null;         //变量初始化
        Socket s = null;

        try {
//            1、创建一个套接字，指定端口号
            ss = new ServerSocket(8070);

//            s = ss.accept();            //阻塞方法()，（错误位置）
//            2、创建线程，让服务器一只运行下去
            while(true){
//                3、同过ServerSocket类的accept()方法获取服务器端的套接字
//                注意这个获取服务器的套接字必须放在while循环中，让他不断获取新线程的套接字，否则会报出Socket关闭的错误，让客户端写入失败
                s = ss.accept();            //阻塞方法()
//                创建线程
                ServerThread st = new ServerThread(s);
                st.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(s != null){
                    s.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(ss != null){
                    ss.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//创建服务器线程
class ServerThread extends Thread{
    Socket s = null;            //局部变量一定要进行初始化
    InputStream is = null;
    ObjectInputStream ois = null;
    OutputStream os = null;
    DataOutputStream dos = null;

    public ServerThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try {
//            接收客户端发送的数据
            is = s.getInputStream();
            ois = new ObjectInputStream(is);
//            获取的数据
            User user = (User)ois.readObject();

//            数据正确，向客户端回馈数据传输正确
            s.shutdownInput();
            os = s.getOutputStream();
            dos = new DataOutputStream(os);

//            判断数据
            if((user.getUsername().equals("nene")) && (user.getPassword().equals("123456"))){
                dos.writeUTF("登录成功");
            }else{
                dos.writeUTF("登录失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(dos != null){
                    dos.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(ois != null){
                    ois.close();
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


