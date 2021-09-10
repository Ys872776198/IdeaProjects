-- 子查询：一个sql语句中有多个select
-- 先查子查询，在查外查询
-- 不相关子查询：子查询可以独立运行
-- 根据查询的结果分为：单行查询和多行查询
select * from emp;

-- 查询部门20中职务同部门10的雇员一样的雇员信息
-- 	查询部门20中所有的职务
SELECT JOB 职务 FROM EMP WHERE DEPTNO = 20;
-- 	查询部门10中所有的职务
SELECT JOB 职务 FROM EMP WHERE DEPTNO = 10;
-- 	查询部门20中职务同部门10的雇员一样的雇员信息
SELECT * FROM EMP
WHERE DEPTNO = 20 
AND JOB IN (SELECT JOB 职务 FROM EMP WHERE DEPTNO = 10);
-- AND JOB = ANY(SELECT JOB 职务 FROM EMP WHERE DEPTNO = 10); -- any 表示等于括号内任意一个即可
-- 
-- 查询工资比所有的“salesman”都高的雇员的编号，名字和工资
SELECT EMPNO 雇员编号, ENAME 雇员名字, SAL 工资
FROM EMP 
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = "salesman");
-- WHERE SAL > all(SELECT sal FROM EMP WHERE JOB = "salesman"); -- all 表示里面所有值，如题：sal比all()里面的 每 一个都大


-- 查询工资低于在任意一个“clerk”的工资的雇员信息
SELECT *
FROM EMP 
WHERE SAL < any(SELECT sal FROM EMP WHERE JOB = "clerk");
-- WHERE SAL < (SELECT max(sal) FROM EMP WHERE JOB = "clerk");	--任意 代表只要员工工资小于其中一个即可



