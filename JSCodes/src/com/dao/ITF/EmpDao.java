package com.dao.ITF;

import com.entity.Emp;

import java.util.List;

/**
 * @Auther: YS
 * @Date: 2021/9/5 22:59
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public interface EmpDao {
//    职员管理系统
//    1、查看指定员工编号的员工
    public Emp FindEmpByEmpno(int empno);

    //    2、查询所有员工
    public List<Emp> FindAllEmps();

    //    3、增加一个员工
    public int AddEmp(Emp emp);

    //    4、删除指定员工编号的员工
    public int DeleteEmp(int empno);
}
