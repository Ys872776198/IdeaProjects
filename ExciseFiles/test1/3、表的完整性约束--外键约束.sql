/*
完整性约束
1、primary key 		:主键约束，约束字段的值可唯一地标识对应的记录
2、not null 			:非空约束,约束字段的值不能为空(无法成为表级约束，只能是列级约束)
3、unique					:唯一约束,约束字段的值是唯一
4、check					:检查约束，限制某个字段的取值范围
5、default				:默认值约束，约束字段的默认值(无法成为表级约束，只能是列级约束)
6、auto_increment	:自增加约束，约束字段的值自动递增(无法成为表级约束，只能是列级约束)
7、foreign key 		:外键约束，约束字段的值自动递增(无法成为列级约束，只能是表级约束)
*/

-- 创建班级表
create table t_class(
cno INT(4) primary key auto_increment,
cname VARCHAR(10) not null,
rome VARCHAR(10) not null
);

-- 创建学生表
CREATE TABLE t_student(
sno INT(4) primary KEY auto_increment,
sname varchar(5) not null,
cno INT(4)
);
-- 创建表后添加外键约束
alter TABLE t_student add constraint fk_stu_cno FOREIGN key (cno) REFERENCES t_class(cno);


-- 给教室表添加数据
insert into t_class values(1, "计算机一班", "s6032");
insert into t_class values(2, "计算机二班", "s6033");
insert into t_class values(3, "计算机三班", "s6034");

-- 给学生添加数据
insert into t_student values(1, "lili", 2);
insert into t_student values(2, "lele", 1);
insert into t_student values(3, "nene", 3);
insert into t_student values(4, "nini", 1);


-- 问题一：在班级表里面删除一个班级，学生表对应的班级没有删除
delete from t_class where cno = 2;

-- 问题二：添加一个学生，这个学生添加一个班级表里面没有的班级，语句运行正常
insert into t_student values(5, "nini", 5);

-- 问题出现的原因：因为外键约束没有使用语法添加进去，现在只是逻辑上认为班级编号是外键，没有通过语法实现

-- 解决办法:添加外键约束
-- 创建学生表
CREATE TABLE t_student(
sno INT(4) primary KEY auto_increment,
sname varchar(5) not null,
cno INT(4),
CONSTRAINT fk_stu_cno FOREIGN key(cno) REFERENCES t_class(cno)
);

-- 查看数据库对象的结构
desc t_student;
desc t_class;

-- 查看t_student的内容
select * from t_student;
select * from t_class;

-- 查看数据库的创建语句
show CREATE table t_student;
show CREATE table t_class;

-- 删除数据库
Drop table t_student;
Drop table t_class;
