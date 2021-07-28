package BiLiExcisesCodes;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/7/28
 * @Description: 网络编程（UDP）
 * @Version: 1.0
 */
//案例：在线聊天
//    发送端（连续聊天，具体的注释参考E66_Send）
public class E67_Send {
    public static void main(String[] args)  {
        System.out.println("!------------学生上线---------!");

        DatagramSocket ds = null;       //局部变量初始化
        try {
            ds = new DatagramSocket(8060);
            while(true){
                Scanner sc = new Scanner(System.in);
                System.out.println("你想对老师说:");
                String str = sc.nextLine();

                byte[] bt = str.getBytes();         //将字符串转换成byte数组
                DatagramPacket dp = new DatagramPacket(bt, bt.length, InetAddress.getByName("localhost"), 8050);        //参数意义参考APL(注意此处的端口号为接收放的端口号)
//            发送数据包
                ds.send(dp);                //通过套接字，将封装的数据包进行发送
//                设定结束的标志
                if("88".equals(str)){
                    System.out.println("学生下线");
                    break;
                }else {
//                    do nothing
                }
//            接收回信
                byte[] bt1 = new byte[1024];
                DatagramPacket dp1 = new DatagramPacket(bt1, bt1.length);     //封装数据包
                ds.receive(dp1);            //接收数据包
                System.out.println("老师对我说：" + (new String(dp1.getData())));
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            4、关闭资源，后开先关
            ds.close();
        }







    }
}
