-- 内连接
SELECT * 
FROM emp
INNER JOIN DEPT
ON(emp.DEPTNO = dept.DEPTNO);

SELECT * FROM EMP;
SELECT * FROM DEPT;

-- 问题：
	-- 1、经过上述子句的对比，发现，由于部门号为40的数据没有对应的员工，在利用内连接查询时，也没有出现部门为40的数据
	-- 2、发现如果部门号为空，同时员工存在其他数据，那么在利用内连接时，这条数据仍然不会出现
 
-- 解决方法：
-- 	外连接 OUTER JOIN
-- 		左外连接 LEFT OUTER JOIN  以左边表的信息为主，即使左边的表不匹配也会查看效果（结合问题2）
SELECT *
FROM emp
LEFT OUTER JOIN dept
ON(emp.DEPTNO = dept.DEPTNO);		-- 须加上

-- 		右外连接 RIGHT OUTER JOIN 以右边表的信息为主，即使右边的表不匹配也会查看效果（结合问题1）
SELECT *
FROM emp
RIGHT OUTER JOIN dept
ON(emp.DEPTNO = dept.DEPTNO);

-- 		全外连接 full OUTER JOIN 可以展示左右两表所有的不匹配数据（这个语法在MySQL中不支持，但是Oracle支持）
-- 		为了解决MySQL中不支持全外连接的问题，将查询的数据使用并集展示（union）
-- 		MySQL对集合的操作比较弱，只支持并集操作。交集，差集都不支持，但是Oracle支持
SELECT *
FROM emp
LEFT OUTER JOIN dept
ON(emp.DEPTNO = dept.DEPTNO)		-- 此处无分号
UNION				-- 并集，去重，效率低
SELECT *
FROM emp
RIGHT OUTER JOIN dept
ON(emp.DEPTNO = dept.DEPTNO);

SELECT *
FROM emp
LEFT OUTER JOIN dept
ON(emp.DEPTNO = dept.DEPTNO)		-- 此处无分号
UNION	ALL			-- 并集，不去重，效率低
SELECT *
FROM emp
RIGHT OUTER JOIN dept
ON(emp.DEPTNO = dept.DEPTNO);





