package com.controller;

import com.dao.ITF.EmpDao;
import com.dao.impl.EmpDaoImpl;
import com.entity.Emp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/9/8 20:00
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class EmpController {
    public static void main(String[] args) {
        System.out.println("功能菜单：");
        System.out.println("1、查询指定员工号的员工信息");
        System.out.println("2、查询所有员工的员工信息");
        System.out.println("3、插入一个员工");
        System.out.println("4、删除指定员工号");
        System.out.println("0、退出");

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的选择：");
        switch (sc.nextInt()){
            case 1:
                FindEmpno();    //1、查看指定员工编号的员工
                break;
            case 2:
                FindAllEmpno(); //2、查询所有员工
                break;
            case 3:
                InsertEmp();    //3、增加一个员工
                break;
            case 4:
                DelEmp();       //4、删除指定员工编号的员工
                break;
            case 0:
                break;
        }
    }

//    1、查看指定员工编号的员工
    public static void FindEmpno(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入员工工号：");
        int i = sc.nextInt();

//        创建数据处理层的对象
        EmpDao ep = new EmpDaoImpl();
        Emp emp = ep.FindEmpByEmpno(i);
        System.out.println(emp);
    }

//    2、查询所有员工
    public static void FindAllEmpno(){
//        创建数据处理层的对象
        EmpDao ep = new EmpDaoImpl();
        List<Emp> emps = ep.FindAllEmps();
        for(Emp emp:emps){
            System.out.println(emp);
        }
    }

//    3、增加一个员工
    public static void InsertEmp(){
//        创建数据处理层的对象
        EmpDao ep = new EmpDaoImpl();
        Emp emp = new Emp();
        int i = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入empno：");
            emp.setEmpno(sc.nextInt());
            while(ep.FindEmpByEmpno(emp.getEmpno()).getEmpno() != 0){
                System.out.println("此人已存在,请重新输入empno：");
                emp.setEmpno(sc.nextInt());
                System.out.println(emp.getEmpno());
                if(ep.FindEmpByEmpno(emp.getEmpno()).getEmpno() == 0){
                    break;
                }else{
//                    do nothing
                }
            }

            System.out.println("请输入ename：");
            emp.setEname(sc.next());
            System.out.println("请输入job：");
            emp.setJob(sc.next());
            System.out.println("请输入mgr：");
            emp.setMgr(sc.nextInt());

            System.out.println("请输入hiredate(格式：yyyy-MM-dd)：");
            String hd = sc.next();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = df.parse(hd);
            emp.setHiredate(d1);

            System.out.println("请输入sal：");
            emp.setSal(sc.nextDouble());
            System.out.println("请输入comm：");
            emp.setComm(sc.nextDouble());
            System.out.println("请输入deptno：");
            emp.setDeptno(sc.nextInt());

            i = ep.AddEmp(emp);
            if(i != 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    4、删除指定员工编号的员工
    public static void DelEmp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入员工工号：");
        int i = sc.nextInt();

//        创建数据处理层的对象
        EmpDao ep = new EmpDaoImpl();
        int a = ep.DeleteEmp(i);
        if(a != 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
