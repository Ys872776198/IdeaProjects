package BiLiExcisesCodes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

/**
 * @Auther: YS
 * @Date: 2021/7/28
 * @Description: 网络编程（UDP）
 * @Version: 1.0
 */
//案例：在线聊天
//    发送端
public class E66_Send {
    public static void main(String[] args) throws IOException {
        System.out.println("!------------学生上线---------!");
//        1、创建套接字，并且指定发送方的端口号(利用DatagramSocket类)
        DatagramSocket ds = new DatagramSocket(8060);
//        2、创建数据包(利用DatagramPacket类)
//            设置要发送的内容
//            自定义发送内容
        Scanner sc = new Scanner(System.in);
        System.out.println("你想对老师说:");
        String str = sc.nextLine();

//        String str = "你好，我是学生";         //输入要发送的内容
        byte[] bt = str.getBytes();         //将字符串转换成byte数组
        DatagramPacket dp = new DatagramPacket(bt, bt.length, InetAddress.getByName("localhost"), 8050);        //参数意义参考APL(注意此处的端口号为接收放的端口号)
//        3、发送数据包
        ds.send(dp);                //通过套接字，将封装的数据包进行发送

//            接收回信
        byte[] bt1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(bt1, bt1.length);     //封装数据包
        ds.receive(dp1);            //接收数据包
//        bt1 = dp1.getData();
        System.out.println("老师对我说：" + (new String(dp1.getData())));;



//        4、关闭资源，后开先关
        ds.close();

    }
}
