-- ---------------------------------------- String 相关 ------------------------------------------
-- LENGTH 返回字节数
select LENGTH('hello');-- 5
select LENGTH('你好');-- utf8中文一个3字节 -- 6

-- CONCAT
select CONCAT('abc','123','ppp');-- abc123ppp
-- CONCAT_WS 带分割符的拼接 WS:WITH SEPARATOR
select CONCAT_WS('-','2003','10','14');-- 2003-10-14


-- SUBSTRING
select SUBSTRING('123456',3,2);-- 34 -- means 从第3个字符开始提取长度为2的字符串
select SUBSTRING('123456',-3,2);-- 45 --means从倒数第3个字符开始提取长度为2的字符串

-- REPLACE
select REPLACE('你好, %name% ,今天好吗?','%name%','Angela');-- 你好, Angela ,今天好吗?

-- TRIM
select CONCAT('%',TRIM('  hhh   '),'%');-- %hhh%
select CONCAT('%',LTRIM('  hhh   '),'%');-- %hhh%
select CONCAT('%',RTRIM('  hhh   '),'%');-- %hhh%


