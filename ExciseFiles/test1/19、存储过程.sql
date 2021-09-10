-- 存储过程：类似于一个类或者方法，将一系列的sql语言进行打包
-- 	优点：
-- 		提高执行能力
-- 		减轻网络负荷
-- 		可将数据库的处理黑匣子化


-- 模糊查询（无返回值）
CREATE PROCEDURE MYPRO1(S VARCHAR(10))		-- 可设置入参，参数名+参数类型
BEGIN			-- 开始
	IF (S IS NULL) OR (S = "")
	THEN	
		SELECT * FROM emp;
	ELSE
		SELECT * FROM EMP 
		WHERE ENAME LIKE CONCAT("%",S,"%");		-- 函数CONCAT可以拼接字符串
	END IF;			-- 这里需要添加end IF
END;				-- 结束

-- 调用
CALL MYPRO1("m");		-- 需要添加入参(不区分大小写)

-- 删除
drop PROCEDURE MYPRO1(S VARCHAR(10));

-- 模糊查询（有返回值）
CREATE PROCEDURE MYPRO2(IN S VARCHAR(10), OUT num INT)		-- 可设置入参，参数名+参数类型。入参前面加IN修饰（IN可以省略），返回值用OUT修饰
BEGIN			-- 开始
	IF (S IS NULL) OR (S = "")
	THEN	
		SELECT * FROM emp;
	ELSE
		SELECT * FROM EMP 
		WHERE ENAME LIKE CONCAT("%",S,"%");		-- 函数CONCAT可以拼接字符串
	END IF;			-- 这里需要添加end IF
	SELECT FOUND_ROWS() INTO NUM;			-- 函数FOUND_ROWS()统计查询的结果有多少行
END;				-- 结束

-- 调用
CALL MYPRO2("m", @num);		-- 需要添加入参(不区分大小写)。返回值要用@修饰
SELECT @NUM;

-- 删除
drop PROCEDURE MYPRO2(S VARCHAR(10));

