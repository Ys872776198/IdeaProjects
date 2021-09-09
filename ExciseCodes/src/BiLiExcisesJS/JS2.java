package BiLiExcisesJS;

import java.sql.*;

/**
 * @Auther: YS
 * @Date: 2021/8/29 00:06
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class JS2 {
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

//     4、发送sql
//            修改，删除，插入用：executeUpdate()方法
//            String sql1 = "update emp set sal = 1500 where EMPNO = 9999;";
//            int i = sta.executeUpdate(sql1);
//            查询使用：executeQuery()方法
            String sql1 = "select * from DEPT;";
            rs = sta.executeQuery(sql1);

//     5、处理结果
//            修改，删除，插入用：executeUpdate()方法
//            if(i > 0){
//                System.out.println("修改成功");
//            }else{
//                System.out.println("修改失败");
//            }

            while(rs.next()){
//            查询使用：executeQuery()方法
                int deptno = rs.getInt(1);      //这里面的 1 代表查询结果的第一行，同时获取的类型要和数据库对应的类型一致,将结果集放到循环中
                String dname = rs.getString(2);
                String loc = rs.getString(3);

//            int deptno = rs.getInt("deptno");      //这里面的 "deptno" 代表查询结果对应的哪一行，同时获取的类型要和数据库对应的类型一致
//            String dname = rs.getString("dname");
//            String loc = rs.getString("loc");

//                System.out.println("deptno" + "\t" + "dname"+ "\t" + "loc");
                System.out.println(deptno + "\t" + dname + "\t" + loc);
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
