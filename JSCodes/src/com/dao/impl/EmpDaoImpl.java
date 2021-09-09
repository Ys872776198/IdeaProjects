package com.dao.impl;

import com.dao.ITF.EmpDao;
import com.entity.Emp;
import com.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YS
 * @Date: 2021/9/5 23:01
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class EmpDaoImpl implements EmpDao {
//    1、查看指定员工编号的员工
    @Override
    public Emp FindEmpByEmpno(int empno) {
        Connection conn = null;
        Statement sta = null;
        Emp emp = new Emp();
//        Emp emp = null;

        try {
//        创建连接
            conn = DBUtils.getConnection();

//        创建会话
            sta = conn.createStatement();

//        发送sql
            ResultSet rs = sta.executeQuery("select * from emp where empno = " + empno);

//        处理结果
            while(rs.next()){
                emp.setEmpno(empno);
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));

//                这里rs.getDate返回的是java.sql.Date，但是EMP里面的hiredate是java.util.Date
//                因此此处需要进经行向上转型，直接将 子类赋值给父类 即可
                emp.setHiredate(rs.getDate(5));
                emp.setSal(rs.getDouble(6));
                emp.setComm(rs.getDouble(7));
                emp.setDeptno(rs.getInt(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtils.getCloseAll(sta, conn);
        }
        return emp;
    }

//    2、查询所有员工
    @Override
    public List<Emp> FindAllEmps() {
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        List<Emp> emps = new ArrayList<>();

        try {

//        创建连接
            conn = DBUtils.getConnection();
//        创建会话
            sta = conn.createStatement();
//        发送sql
            String sql = "select * from emp";
            rs = sta.executeQuery(sql);
//        处理结果
            while(rs.next()){
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));

//                这里rs.getDate返回的是java.sql.Date，但是EMP里面的hiredate是java.util.Date
//                因此此处需要进经行向上转型，直接将 子类赋值给父类 即可
                emp.setHiredate(rs.getDate(5));
                emp.setSal(rs.getDouble(6));
                emp.setComm(rs.getDouble(7));
                emp.setDeptno(rs.getInt(8));

                emps.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭资源
            DBUtils.getCloseAll(rs, sta, conn);
        }

        return emps;
    }

//    3、增加一个员工
    @Override
    public int AddEmp(Emp emp) {
        String sql = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
        java.sql.Date d1 = new java.sql.Date(emp.getHiredate().getTime());
        Object[] obj = {emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(), d1, emp.getSal(), emp.getComm(), emp.getDeptno()};

        int i = DBUtils.getFindEmp(sql, obj);

//        Connection conn = null;
//        PreparedStatement ps = null;
//        int i = 0;
//
//        try {
////        创建连接
//            conn = DBUtils.getConnection();
////        创建会话
//            String sql = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
//            ps = conn.prepareStatement(sql);
//
//            ps.setInt(1, emp.getEmpno());
//            ps.setString(2, emp.getEname());
//            ps.setString(3, emp.getJob());
//            ps.setInt(4, emp.getMgr());
//
////            ps.setDate接收的是java.sql.Date,但是emp.getHiredate返回的是java.util.Date
////            因此需要向下转型
//            java.util.Date d1 = emp.getHiredate();
//            java.sql.Date d2 = new java.sql.Date(d1.getTime());
//
//            ps.setDate(5, d2);
//
//            ps.setDouble(6, emp.getSal());
//            ps.setDouble(7, emp.getComm());
//            ps.setInt(8, emp.getDeptno());
//
//            i = ps.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }finally {
//            DBUtils.getCloseAll(ps, conn);
//        }

        return i;
    }

//    4、删除指定员工编号的员工
    @Override
    public int DeleteEmp(int empno) {

        String sql = "delete from emp where empno = ? ;";
        int i = DBUtils.getFindEmp(sql, empno);

//        Connection conn = null;
//        PreparedStatement ps = null;
//        int i = 0;
//
//        try {
////            创建会话
//            conn = DBUtils.getConnection();
////            创建连接
//            String sql = "delete from emp where empno = ? ;";
//            ps = conn.prepareStatement(sql);
////            发送sql
//            ps.setInt(1, empno);
//            i = ps.executeUpdate();
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }finally {
//            DBUtils.getCloseAll(ps, conn);
//        }

        return i;
    }
}
