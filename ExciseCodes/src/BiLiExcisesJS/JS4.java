package BiLiExcisesJS;

import java.sql.*;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/8/29 23:11
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class JS4 {
    public static void main(String[] args)  {
//        完成一个JDBC的操作
        String dirver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test1";        //jdbc:mysql://<host>:<port>/<database_name>
        String username = "root";
        String password = "root";
        Connection conn = null;
//        Statement sta = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
//     1、加载驱动
            Class c1 = Class.forName(dirver);        //利用发射获取Driver类的字节码信息
//     2、创建连接
//            利用DriverManager类的getConnection()方法连接sql。其中参数为连接数据库的名字，密码，账号
            conn = DriverManager.getConnection(url, username, password);

//     3、创建会话
            /**
             * PreparedStatement好处：
             * 1、代码的可读性和维护性
             * 2、最重要的一点是极大地提高了安全性
             * 3、PreparedStatement尽最大可能提高性能
             *      例如：使用语句 int i = sta.executeUpdate("update emp set sal = 1500 where EMPNO = 9999;"); 查询一万次，那么他就会编译一万次
             *      但是使用语句 ps = conn.prepareStatement("update emp set sal = ？ where EMPNO = ？;"); 查询一万次，它只会编译一次，
             */
//            问题：当在输入密码时，输入的字符串是一个恒成立的语句（类似：123132 or "1" = "1"）时，那么sql语句也会显示登录成功
//            解决方法：使用preparedStatement()方法，来 创建会话 并且 预编译sql
            ps = conn.prepareStatement("select username, passname from user1 where username = ? and passname = ?;");        //?相当于占位符


//     4、发送sql
//            从键盘录入数据：
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String un = sc.nextLine();
            System.out.println("请输入密码：");
            int pw = sc.nextInt();


//            查询使用：executeQuery()方法
            ps.setString(1, un);        //这里的1代表第几个占位符，1即代表第一个 ？ ，2代表第二个 ？
            ps.setInt(2, pw);
            rs = ps.executeQuery();

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
                if(ps != null){
                    ps.close();
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
