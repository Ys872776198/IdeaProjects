package BiLiExcisesJS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: YS
 * @Date: 2021/8/23 22:11
 * @Description: JS1
 * @Version: 1.0
 */
public class JS1 {
    public static void main(String[] args)  {
//        完成一个JDBC的操作
        String dirver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test1";        //jdbc:mysql://<host>:<port>/<database_name>
        String username = "root";
        String password = "root";
        Connection conn = null;
        Statement sta = null;

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
            String sql1 = "update emp set sal = 1500 where EMPNO = 9999;";
            int i = sta.executeUpdate(sql1);

//     5、处理结果
            if(i > 0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//     6、关闭资源
//            先关闭会话

            try {
                if(sta != null){
                    sta.close();
                }else{
//                    do nothing
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            再关闭连接
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
