-- 创建数据库
create table t_student(
sno INT(6),
sname VARCHAR(5),
age INT(3),
sex CHAR(1),
classtime DATE,
classname VARCHAR(10),
email VARCHAR(15)
);

-- 使用char和int数据类型时，可以不添加长度，但是使用varchar要添加长度
-- int类型在数据超过指定长度后，会自动扩展
-- 但是浮点型float double不会拓展。double(5,1) 5代表总宽度，1代表小数点后的占位
-- 字符串类型char类型长度固定（指定几个字符就存几个），但是varchar类型长度可变（指定宽度以内的都可以）
-- 					 BLOB类型可以用来存放音频视频等待，text类型用来存放长文本数据
-- create table t_student2(
-- sno INT(6),
-- sname VARCHAR(5),
-- age INT(3),
-- sex CHAR(1),
-- classtime DATE,
-- classname VARCHAR(10),
-- email VARCHAR(15)
-- );
-- 
-- create table t_student3(
-- sno INT,
-- sname VARCHAR(5),
-- age INT(3),
-- sex CHAR,
-- classtime DATE,
-- classname VARCHAR(10),
-- email VARCHAR(15)
-- );

-- 查看表的结构，显示表的字段详细信息（直接desc + 数据库对象 即可）
DESC t_student;

-- 查看表的数据
select * from t_student;

-- 查看建表语句(show + 创建数据表的语句)
show CREATE TABLE t_student;
-- 结果如下：
-- t_student	CREATE TABLE `t_student` (
--   `sno` int(6) DEFAULT NULL,
--   `sname` varchar(5) DEFAULT NULL,
--   `age` int(3) DEFAULT NULL,
--   `sex` char(1) DEFAULT NULL,
--   `classtime` date DEFAULT NULL,
--   `classname` varchar(10) DEFAULT NULL,
--   `email` varchar(15) DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- 向t_student中添加数据
/*
注意事项
1、int类型的实际宽度超过指定的宽度，系统会自动拓长，最大4个字节
2、时间的方法时多样性的"2021/8/12","2021-8-12","2021.8.12"都可以
3、字符串不区分单引号和双引号
4、获取当前时间可以使用函数 now(), sysdate(), `CURRENT_DATE`()
*/

INSERT INTO t_student VALUES(1312, "nene", 18, "女", "2021/8/12", "电商1", "3189728@QQ.COM");
INSERT INTO t_student VALUES(1313, "lili", 18, "女", "2021-8-10", "电商2", "3189729@QQ.COM");
INSERT INTO t_student VALUES(1314, "lele", 19, "女", now(), "电商2", "3189730@QQ.COM");
-- INSERT INTO t_student(son, sex, classtime) VALUES(1315,  "女", now());

-- 向t_student中删除和修改数据
/*
注意事项：
1、关键字，表明，字段不区分大小写
2、默认情况下，内容不区分大小写
3、删除操作from关键字不可缺少
4、修改删除数据别忘了加限制条件
*/
-- 修改
update t_student set age = 19 WHERE sname = "lili" ;

-- 删除
delete from t_student where classname = "电商";
delete from t_student where sno = "1315";

-- 向t_student中删除和修改的结构
-- 修改数据库对象
-- 	增加一列（出现在表的末尾）
ALTER table t_student add score double(4,1);
-- 	增加一列（出现在表的首位）
ALTER table t_student add score double(4,1) first;

-- 	增加一列（出现在表的指定位置）
ALTER table t_student add score double(4,1) after age;
UPDATE t_student set score = 100.2 WHERE sname = "nene";

-- 	删除一列
alter table t_student drop score;

-- 	修改一列
alter table t_student modify score float(5, 1);		-- modify 修改的是列的类型定义，但是不会改变列的名字
alter table t_student change socre score1 float(5, 1);		-- CHANGE 可以修改的列的类型定义和列的名字

-- 删除数据库对象
drop TABLE t_student;



