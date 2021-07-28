package BiLiExcisesCodes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/7/28
 * @Description: 网络编程（UDP）
 * @Version: 1.0
 */
//案例：在线聊天
//    接收端
public class E66_Receive {
    public static void main(String[] args) throws IOException {
        System.out.println("!------------老师上线---------!");
//        1、创套接字，指定接收方的端口号
        DatagramSocket ds = new DatagramSocket(8050);
//        2、接收数据包
        byte[] bt = new byte[1024];         //需要一个接收数据的byte数组
        DatagramPacket dp = new DatagramPacket(bt, bt.length);      //具体参数参考API(此时的数据包为空)
//        3、接收过来的数据，将数据放入数据包
        ds.receive(dp);                                             //接收数据，并放入数据包(此时的数据包不为空)(阻塞方法)
//        4、输出数据
        bt = dp.getData();
        System.out.println("学生对我说：" + new String(bt));

//            回复
//            自定义回复
        Scanner sc = new Scanner(System.in);
        System.out.println("你想对学生说:");
        String s = sc.nextLine();
//        String s = "你也好，我是老师";
        byte[] bt1 = s.getBytes();
        DatagramPacket dp1 = new DatagramPacket(bt1, bt1.length, InetAddress.getByName("localhost"), 8060);     //封装数据包
        ds.send(dp1);       //发送数据包


//        5、关闭资源，后开先关
        ds.close();
    }
}
