-- 视图的概念
-- 视图：是一个或者多个基础数据表或者其他视图中构建出来的虚拟表
-- 视图的好处：
-- 简化用户操作：视图可以使用户将注意力集中在所关心的数据上，而不需要关心数据表的结构、与其他的表的关联条件已经查询条件等


CREATE OR REPLACE VIEW MYVIEW1		-- CREATE OR REPLACE 表示:视图如果不存在就创建，存在就进行替换（REPLACE 表示为替换视图）
AS
SELECT *
FROM EMP
WHERE DEPTNO = 20
WITH CHECK OPTION;		--  CHECK OPTION 表示：对插入数据进行检查，不满足创建视图的条件时，数据无法插入


SELECT * FROM MYVIEW1;
SELECT * FROM EMP;			-- 在对视图操作时，其实就是对组成视图的那些表格进行操作

DROP VIEW MYVIEW1;


-- (未加 CHECK OPTION)
INSERT INTO MYVIEW1 VALUES(9998, "SMITH", "CLERK", 7902, "1980-12-17", 800, 500, 30);		-- 当添加的数据不满足视图的筛选要求时，实际也会添加到基础表中，且在基础表可查，但视图中不可查 
-- (已加 CHECK OPTION)
INSERT INTO MYVIEW1 VALUES(9997, "SMITH", "CLERK", 7902, "1980-12-17", 800, 1000, 30);









