-- 多表查询
-- 	交叉连接 cross join （cross在MySQL中不省略不写，在oracle中不能省略）
SELECT DISTINCT DEPT.DEPTNO, DNAME, JOB 
	FROM EMP JOIN DEPT  
		ORDER BY DEPT.DEPTNO ASC;

-- 	自然连接 natural join(优点：会自动匹配所有同名列，并且同名列只会显示一次)
-- 	缺点：查询字段时，没有指定字段所属的数据库，效率低
-- 	解决方法：给字段指定表名（表明.字段）
SELECT DEPT.DEPTNO, DEPT.DNAME, emp.JOB ,salgrade.GRADE
	FROM EMP NATURAL JOIN DEPT
	NATURAL JOIN SALGRADE
		ORDER BY DEPTNO ASC;


-- 	缺点：表名太长
-- 	解决方法：给表起别名
-- SELECT DEPT.DEPTNO, DEPT.DNAME, "职工".JOB			
-- 	FROM EMP AS "职工" NATURAL JOIN DEPT				-- 别名最好不要加引号，且AS可以省略（如下）
-- 		ORDER BY DEPTNO ASC;

SELECT DEPT.DEPTNO, DEPT.DNAME, 职工.JOB 
	FROM EMP AS 职工 NATURAL JOIN DEPT
		ORDER BY DEPTNO ASC;

-- 	缺点:当自然连接的表存在多个同名列时，系统会自动把所有同名列都匹配，但是有时候只需要匹配部分同名列
-- 	解决方法：内连接 using子句
SELECT * 
	FROM EMP
	INNER JOIN dept			-- INNER可以省略不写
	USING (DEPTNO);			-- 这里不写natural join ，这里是内连接

-- 	USING 缺点:using 关联的字段必须时同名的，有时候会遇到不是同名但是需要匹配的字段
-- 	解决方法：on 子句(使用最多)
SELECT *
FROM EMP
JOIN dept
ON(EMP.DEPTNO = DEPT.DEPTNO);










