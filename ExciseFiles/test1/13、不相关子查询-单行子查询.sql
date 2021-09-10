-- 子查询：一个sql语句中有多个select
-- 先查子查询，在查外查询
-- 不相关子查询：子查询可以独立运行
-- 根据查询的结果分为：单行查询和多行查询
select * from emp;

-- 查询所有比“clark”工资高的员工信息
-- 	查询“Clark”的工资
SELECT ENAME, SAL 工资 FROM EMP WHERE ENAME = "CLARK";

-- 	查询所有比“clark”工资高的员工信息
SELECT * FROM EMP WHERE SAL > (SELECT SAL 工资 FROM EMP WHERE ENAME = "CLARK");

-- 查询工资高于平均工资的雇员名字和工资
-- 	查询平均工资
SELECT AVG(SAL) 平均工资 from EMP;

-- 	查询工资高于平均工资的雇员名字和工资
SELECT ENAME, SAL FROM EMP WHERE SAL > (SELECT AVG(SAL) 平均工资 from EMP); 


-- 查询和“Clark”同一部门且工资比他高的雇员和工资
-- 	查询“Clark”部门和工资
SELECT SAL FROM EMP WHERE ENAME = "clark";
SELECT ENAME 员工姓名, DNAME 部门姓名 
FROM EMP 
LEFT OUTER JOIN DEPT
ON(EMP.DEPTNO = DEPT.DEPTNO)
WHERE ENAME = "clark";

-- 	查询和“Clark”同一部门且工资比他高的雇员和工资
SELECT ENAME 员工姓名, SAL 工资 
FROM EMP 
LEFT OUTER JOIN DEPT
ON(EMP.DEPTNO = DEPT.DEPTNO)
WHERE  SAL > (SELECT SAL FROM EMP WHERE ENAME = "clark") 
AND DNAME = (SELECT  DNAME  
FROM EMP 
LEFT OUTER JOIN DEPT
ON(EMP.DEPTNO = DEPT.DEPTNO)
WHERE ENAME = "clark") ;

-- 查询职务和“Scott”相同，比Scott雇佣时间早的雇员信息
-- 	查询“scott”的职务和入职时间
SELECT JOB FROM EMP WHERE ENAME = "SCOTT";
SELECT HIREDATE FROM EMP WHERE ENAME = "SCOTT";

-- 	查询所有雇员信息
SELECT * 
FROM EMP 
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = "SCOTT")
AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = "SCOTT");


