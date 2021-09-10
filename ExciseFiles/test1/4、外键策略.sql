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

-- 因为有外键联系，所以直接删除班级编号是不行的
-- 解决方法：加入外键策略：
-- 策略1、no action 不允许操作
-- 		通过操作sql语言来完成：
-- 				1、先把学生对应的班级设为 NULL
update t_student set cno = null where cno = 3; 
-- 				2、再删除对应班级
delete from t_class WHERE cno = 3;

-- 策略2、cascade 级联操作：操作主表影响从表的外键信息
-- 		1、先删除之前的外键联系
alter table t_student drop FOREIGN key fk_stu_cno;

-- 		2、再重新添加外键联系
alter table t_student add CONSTRAINT fk_stu_cno foreign key (cno) REFERENCES t_class(cno) on UPDATE CASCADE on delete CASCADE;
-- 测试：
-- 	1、删除班级2，看对应的学生有没有跟新（已同步更新）
delete from t_class where cno = 2;
-- 	2、将班级3修改为班级5，看对应的学生有没有跟新（已同步更新）
update t_class set cno = 5 where cno = 3; 

-- 策略3、set null 置空操作：
-- 		1、先删除之前的外键联系
alter table t_student drop FOREIGN key fk_stu_cno;

-- 		2、再重新添加外键联系
alter table t_student add CONSTRAINT fk_stu_cno foreign key (cno) REFERENCES t_class(cno) on UPDATE set null on delete set NULL;
-- 测试：
-- 	1、删除班级2，看对应的学生有没有跟新（已同步更新）
delete from t_class where cno = 2;
-- 	2、将班级3修改为班级5，看对应的学生有没有跟新（已同步更新）
update t_class set cno = 5 where cno = 3; 

-- 注意：级联操作和置空操作可以混合使用
-- 	1、修改为级联，删除为置空
alter table t_student add CONSTRAINT fk_stu_cno foreign key (cno) REFERENCES t_class(cno) on UPDATE CASCADE on delete set NULL;
-- 测试：
-- 	1、删除班级2，看对应的学生有没有跟新（已同步更新）
delete from t_class where cno = 2;
-- 	2、将班级3修改为班级5，看对应的学生有没有跟新（已同步更新）
update t_class set cno = 5 where cno = 3; 

-- 	2、修改为置空，删除为级联
alter table t_student add CONSTRAINT fk_stu_cno foreign key (cno) REFERENCES t_class(cno) on UPDATE set NULL on delete CASCADE;
-- 测试：
-- 	1、删除班级2，看对应的学生有没有跟新（已同步更新）
delete from t_class where cno = 2;
-- 	2、将班级3修改为班级5，看对应的学生有没有跟新（已同步更新）
update t_class set cno = 5 where cno = 3; 




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
