select * from DEPT;
select * from EMP;
select * from SALGRADE;

-- 查询三个表
SELECT *
FROM emp
NATURAL JOIN dept
-- ON(EMP.DEPTNO = DEPT.DEPTNO)
 JOIN salgrade
ON EMP.SAL BETWEEN salgrade.LOSAL AND salgrade.HISAL;

SELECT *
FROM emp
INNER JOIN dept
ON(EMP.DEPTNO = DEPT.DEPTNO)
INNER JOIN salgrade
ON EMP.SAL BETWEEN salgrade.LOSAL AND salgrade.HISAL;
-- INNER JOIN dept2		--增加表，在后面直接增加 连接 就行
-- INNER JOIN dept3
