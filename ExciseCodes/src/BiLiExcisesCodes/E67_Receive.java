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
//    接收端（连续聊天，具体的注释参考E66_Send）
public class E67_Receive {
    public static void main(String[] args)  {
        System.out.println("!------------老师上线---------!");
//        1、创套接字，指定接收方的端口号
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8050);
          while (true){
              //        2、接收数据包
              byte[] bt = new byte[1024];         //需要一个接收数据的byte数组
              DatagramPacket dp = new DatagramPacket(bt, bt.length);      //具体参数参考API(此时的数据包为空)
//        3、接收过来的数据，将数据放入数据包
              ds.receive(dp);                                             //接收数据，并放入数据包(此时的数据包不为空)(阻塞方法)
//        4、输出数据
              bt = dp.getData();
              String str =  new String(bt, 0, dp.getLength());
              System.out.println("学生对我说：" + str);   //这里必须要指定数组的有长度，因为不指定长度，系统会将长度为1024的数组全部转换为String,
              //这样会影响结束位的判断
              if("88".equals(str)){
                  System.out.println("学生下线");
                  break;
              }else {
//                    do nothing
              }
//            回复
//            自定义回复
              Scanner sc = new Scanner(System.in);
              System.out.println("你想对学生说:");
              String s = sc.nextLine();
//        String s = "你也好，我是老师";
              byte[] bt1 = s.getBytes();
              DatagramPacket dp1 = new DatagramPacket(bt1, bt1.length, InetAddress.getByName("localhost"), 8060);     //封装数据包
              ds.send(dp1);       //发送数据包
          }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //        5、关闭资源，后开先关
            ds.close();
        }
    }
}
