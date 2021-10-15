package com.test;

import com.dao.ITF.EmpDao;
import com.dao.impl.EmpDaoImpl;
import com.entity.Emp;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: YS
 * @Date: 2021/9/5 00:34
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class TestFanction {

//    1、查看指定员工编号的员工
    @Test
    public void testFindEmpByEmpno(){
        EmpDao ed = new EmpDaoImpl();
        Emp emp = ed.FindEmpByEmpno(8888);
        System.out.println(emp);
    }

//    2、查询所有员工
    @Test
    public void testFindAllEmps(){
        EmpDao ed = new EmpDaoImpl();
        List<Emp> emps = ed.FindAllEmps();
//        用增强for循环，遍历所有结果
        for (Emp emp : emps){
            System.out.println(emp);
        }

//        Iterator<Emp> it = emps.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

    }

//    3、增加一个员工
    @Test
    public void testAddEmp(){

        try {
            Emp emp = new Emp();
            emp.setEmpno(8888);
            emp.setEname("gaga");
            emp.setJob("clerk");
            emp.setMgr(7900);

//        String --> java.util.Date
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            emp.setHiredate(df.parse("1990-01-20"));

            emp.setSal(800);
            emp.setComm(300);
            emp.setDeptno(30);

            EmpDao ed = new EmpDaoImpl();

            int i = ed.AddEmp(emp);
            if(i != 0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

//    4、删除指定员工编号的员工
    @Test
    public void testDeleteEmp(){
        EmpDao ed = new EmpDaoImpl();
        int i = ed.DeleteEmp(8888);
        if(i > 0 ){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
    }


}
