package com.util;

import java.sql.*;

/**
 * @Auther: YS
 * @Date: 2021/9/7 23:05
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class DBUtils {

//    创建连接数据库的方法
    public static Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test1";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
//        获取字节码信息
            Class<?> c1 = Class.forName(driver);
//        创建连接
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static  void getCloseAll(Statement sta, Connection conn){
//        关闭资源
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
//            在关闭连接
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

//    创建关闭资源方法
    public static void getCloseAll(ResultSet rs, Statement sta, Connection conn){
//        关闭资源
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
//            在关闭连接
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

//    提取 删除，插入，修改的功能
    public static int getFindEmp(String sql, Object... obj){
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;

        try {
//            创建会话
            conn = DBUtils.getConnection();
//            创建连接,发送sql
            ps = conn.prepareStatement(sql);
//            处理结果
            for(int a = 0; a < obj.length ; a++){
                ps.setObject((a+1), obj[a]);
            }
            i = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtils.getCloseAll(ps,conn);
        }
        return i;
    }
}
