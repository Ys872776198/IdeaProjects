
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

-- 建立一张存储学生信息的表
-- 要求：
-- 1、学生是主键，不能为空，唯一
-- 2、如果主键是int类型，那么要求自加
-- 3、姓名不能为空
-- 4、Email唯一
-- 5、性别默认为男
-- 6、性别只有男女
-- 7、年龄只能在18~50之间

-- 创建数据库（列级约束）
create table t_student(
sno INT(6) PRIMARY key auto_increment,
sname VARCHAR(5) not NULL,
age INT(3) CHECK(age >= 18 and age <= 50),
sex CHAR(1) default "男" check(sex = "男" or sex = "女"),
classtime DATE,
classname VARCHAR(10),
email VARCHAR(15) UNIQUE
);

-- 创建数据库（表级约束）
create table t_student(
sno INT(6) auto_increment,
sname VARCHAR(5) not NULL,
age INT(3),
sex CHAR(1) default "男",
classtime DATE,
classname VARCHAR(10),
email VARCHAR(15),
constraint pk_stu_sno primary key (sno),
constraint ck_stu_age check(age >= 18 && age <=50),
constraint ck_stu_sex check(sex = "男" or sex = "女"),
constraint un_stu_email unique(email)
);

-- 创建数据库
create table t_student(
sno INT(6),
sname VARCHAR(5) not NULL,
age INT(3),
sex CHAR(1) default "男",
classtime DATE,
classname VARCHAR(10),
email VARCHAR(15)
);
-- 创建表之后添加约束
alter table t_student add constraint pk_stu_sno primary key (sno);
alter table t_student modify sno int(6) auto_increment;														-- 修改自增条件，使用modify时要把类型和宽度带上
alter table t_student add constraint ck_stu_age check(age >= 18 && age <=50);
alter table t_student add constraint ck_stu_sex check(sex = "男" or sex = "女");
alter table t_student add constraint un_stu_email unique(email);


-- 插入数据
INSERT INTO t_student VALUES(1312, "nene", 18, "女", "2021/8/12", "电商1", "3189728@QQ.COM");
INSERT INTO t_student VALUES(1313, "lili", 18, "女", "2021-8-10", "电商2", "3189729@QQ.COM");
INSERT INTO t_student VALUES(1314, "lele", 19, "男", now(), "电商2", "3189730@QQ.COM");
-- 如果主键没有设定值，或者用努力了，default，都可以完成主键的自加
INSERT INTO t_student VALUES(null, "lele", 19, "男", now(), "电商2", "3189731@QQ.COM");
INSERT INTO t_student VALUES(default, "lele", 19, "男", now(), "电商2", "3189732@QQ.COM");
INSERT INTO t_student(sname, age, sex, classtime, classname, email) VALUES("lele", 19, "男", now(), "电商2", "3189733@QQ.COM");
-- 如果sql报错，可能造成主键浪费，导致后续的主键不是连号的，但是只要主键是唯一，却能区分数据即可
INSERT INTO t_student VALUES(default, "lele", 52, "男", now(), "电商2", "3189734@QQ.COM");
INSERT INTO t_student(sname, age, sex, classtime, classname, email) VALUES("lele", 19, "男", now(), "电商2", "3189735@QQ.COM");

delete from t_student where email = "3189735@QQ.COM";

-- 查看数据库对象的结构
desc t_student;

-- 查看t_student的内容
select * from t_student;

-- 查看数据库的创建语句
show CREATE table t_student;

-- 删除数据库
Drop table t_student;
