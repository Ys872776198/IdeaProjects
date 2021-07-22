package BiLiExcisesCodes;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @Auther: YS
 * @Date: 2021/7/21
 * @Description: 网络编程
 * @Version: 1.0
 */
public class E60 {
    public static void main(String[] args) throws UnknownHostException {
//        类：InetAddress ———— 封装IP
//        InetAddress ia = new InetAddress();         //这个方法没有被范围修饰符修饰，所以默认为default修饰，作用范围在当前包里面，所以InetAddress类不能直接创建对象
        //getByName()被static修饰，入参为IP地址，或者"localhost"("localhost"指代的是当前电脑的IP地址)，或者输入当前电脑当前用户名，或者域名(DNS会自动解析，转成相应的域名)
//        InetAddress ia = InetAddress.getByName("192.168.1.106");        //入参为IP地址
//        System.out.println(ia);
//
//        InetAddress ia2 = InetAddress.getByName("localhost");           //入参为"localhost"("localhost"指代的是当前电脑的IP地址),在控制台上打印的数据也是IP地址
//        System.out.println(ia2);
//
//        InetAddress ia3 = InetAddress.getByName("DESKTOP-D61HP59");     //入参为电脑当前用户名
//        System.out.println(ia3);
//
//        InetAddress ia4 = InetAddress.getByName("www.baidu.com");       //入参为域名
//        System.out.println(ia4);
//
//        System.out.println(ia.getHostAddress());                        //获取IP地址
//        System.out.println(ia.getHostName());                           //获取域名

//        类：InetSocketAddress ———— 封装IP和port口
        InetSocketAddress isa = new InetSocketAddress("localhost", 8070);
        System.out.println(isa);

        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());
        System.out.println("-------------------------");

        InetAddress ia5 = isa.getAddress();
        System.out.println(ia5.getHostName());
        System.out.println(ia5.getHostAddress());


    }
}
