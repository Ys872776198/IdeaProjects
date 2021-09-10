-- 创建数据库表
create table t_student(
sno INT(6) PRIMARY key auto_increment,
sname VARCHAR(5) not NULL,
age INT(3) CHECK(age >= 18 and age <= 50),
sex CHAR(1) default "男" check(sex = "男" or sex = "女"),
classtime DATE,
classname VARCHAR(10),
email VARCHAR(15) UNIQUE
);

-- 添加数据
INSERT INTO t_student VALUES(1312, "nene", 18, "女", "2021/8/12", "电商1", "3189728@QQ.COM");
INSERT INTO t_student VALUES(1313, "lili", 18, "女", "2021-8-10", "电商2", "3189729@QQ.COM");
INSERT INTO t_student VALUES(1314, "lele", 19, "男", now(), "电商2", "3189730@QQ.COM");

-- 快速创建一张表，结构和数据与t_student一样
CREATE table t_student2 
AS
SELECT * from t_student;

-- 快速创建一张表，结构和t_student一样，但是数据不同
CREATE table t_student3 
AS
SELECT * from t_student where 2 = 3;	-- 2=3，这个条件不会满足，因此t_student3没有录入t_student的数据，但是会复制他的结构

-- 快速创建一张表，部分结构和t_student一样，且部分数据相同
CREATE table t_student4 
AS
SELECT sno, sname, age from t_student where sno= 1314;

-- 删除数据操作
/*
delete属于DML，truncate属于DDL。两者都可以删除数据库中的数据
不同：
-- 	delete:是一条一条的删除直到删除完。delete操作可以回滚，且会返回删除的行数。

-- 	truncate:是保留了表的结构，重新创建了这个表，这个表相当于新表。turncate操作不能回滚，清楚完毕后不会返回删除的行数。truncate操作的效率更高
*/
-- 	delete
delete FROM t_student; 
-- 	truncate
truncate table t_student2;




-- 查看数据库对象的结构
desc t_student;

-- 查看t_student的内容
select * from t_student2;

-- 查看数据库的创建语句
show CREATE table t_student;

-- 删除数据库
Drop table t_student;
