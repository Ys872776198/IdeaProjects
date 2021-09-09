package BiLiExcisesJS;

import java.sql.*;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/8/29 00:35
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class JS3 {
    public static void main(String[] args)  {
//        完成一个JDBC的操作
        String dirver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test1";        //jdbc:mysql://<host>:<port>/<database_name>
        String username = "root";
        String password = "root";
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;

        try {
//     1、加载驱动
            Class c1 = Class.forName(dirver);        //利用发射获取Driver类的字节码信息
//     2、创建连接
//            利用DriverManager类的getConnection()方法连接sql。其中参数为连接数据库的名字，密码，账号
            conn = DriverManager.getConnection(url, username, password);

//     3、创建会话
//            利用Connection接口中的createStatement()方法，创建一个 Statement 对象来将 SQL 语句发送到数据库
            sta = conn.createStatement();
//            PreparedStatement ps = conn.prepareStatement();


//     4、发送sql
//            从键盘录入数据：
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String un = sc.nextLine();
            System.out.println("请输入密码：");
            int pw = sc.nextInt();


//            查询使用：executeQuery()方法
//            String sql1 = "select"+ un + "," + pw + "from DEPT;";
            String sql1 = "select username, passname from user1 where username ="+ "\"" + un +"\"" + " " + "and" + " " + "passname =" + pw + ";";
            System.out.println(sql1);
            rs = sta.executeQuery(sql1);

//     5、处理结果
            if (rs.next()){
                System.out.println("账号存在，登录成功！");
            }else {
                System.out.println("账号不存在，登录失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//     6、关闭资源
//            关闭结果集
            try {
                if(rs != null){
                    rs.close();
                }else{
//                    do nothing
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            关闭会话

            try {
                if(sta != null){
                    sta.close();
                }else{
//                    do nothing
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            关闭连接
            try {
                if(conn != null){
                    conn.close();
                }else{
//                    do nothing
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
