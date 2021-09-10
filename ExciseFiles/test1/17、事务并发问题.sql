-- 事务并发问题：
-- 脏读：				当事务一访问数据并且修改数据时（未提交），另外事务二在读取数据时，读取到了事务一已修改但未提交的数据。即读取到了错误数据
-- 不可重复读：	当事务一在读取数据时（事务一没有修改数据的操作，只进行查询操作），事务二在访问并且修改数据，在数据提交后，数据库的内容发生了修改，
-- 							那么在此时，事务一读取的数据发生了改变，也就是说在事务一没有修改数据操作的前提下，两次查询的数据不同
-- 幻读：				幻读和不可重复读相似，都是多次读取数据，但是数据内容不同

-- 幻读和不可重复读区别：
-- 	1：不可重复读重点是修改，幻读重点是新增或者删除
-- 	2：解决不可重读读只需要锁住满足条件的行，解决幻读需要锁住表

隔离级别(低到高)		脏读		不可重复读		幻读
READ UNCOMMITTED		不行		不行					不行
READ COMMITTED			行			不行					不行
REPEATABLE READ			行			行						不行		（使用最多）
SERIALIZABLE				行			行						行


-- 查看默认的事务隔离级别 MySQL默认的是repeatable read(重复读取)
SELECT @@TRANSACTION_ISOLATION;
-- 设置事务的隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;









