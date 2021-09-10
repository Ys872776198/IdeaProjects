-- 不相关子查询：	子查询可以独立运行，先运行子查询，在运行外查询
-- 相关子查询：		子查询不可以独立运行，并且先运行外查询，在运行子查询

-- 不相关子查询优缺点:
-- 优点：	简单，功能强大
-- 缺点：	稍难理解


-- 查询部门最高工资的员工(不相关子查询)
SELECT *
FROM emp
WHERE SAL = (SELECT MAX(SAL) FROM emp);

-- 查询本部门最高工资的员工（相关子查询）
-- 	查询指定部门20中最高工资的员工
SELECT *
from emp
WHERE DEPTNO = 20 AND SAL = (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 20)

-- 查询任意部门中最高工资的员工
SELECT *
from emp E1
WHERE SAL = (SELECT MAX(SAL) FROM EMP E2 WHERE E1.DEPTNO = E2.DEPTNO);	-- E1.DEPTNO = E2.DEPTNO代表外循环的部门和内循环的部门相同时，该部门的最高工资



-- 查询工资高于其所在岗位的平均工资的那些员工(相关子查询)
-- 	查询工资高于其所在“ANALYST”岗位的平均工资的那些员工
SELECT * 
FROM EMP E1
WHERE JOB = "ANALYST" 
AND SAL >= (SELECT AVG(SAL) FROM EMP E2 WHERE JOB = "ANALYST");


-- 	查询工资高于其所在岗位的平均工资的那些员工
SELECT * 
FROM EMP E1
WHERE SAL >= (SELECT AVG(SAL) FROM EMP E2 WHERE E1.JOB = E2.JOB)
ORDER BY JOB DESC;