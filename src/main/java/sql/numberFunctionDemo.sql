-- ABS求绝对值，SIGN求符号，负数-1，零0，正数1
SELECT ABS(-10);      -- 10
SELECT SIGN(-10);     -- -1
SELECT SIGN(0);       -- 0
SELECT SIGN(10);      -- 1

-- CEILING 和 FLOOR 和 ROUND
-- 向上取整 和 向下取整 和 四舍五入
SELECT CEILING(3.2);-- 4
SELECT FLOOR(3.2);-- 3
SELECT ROUND(3.2);-- 3
SELECT ROUND(3.5);-- 4

-- ROUND 保留n位小数(基于四舍五入)
SELECT ROUND(3.87,1); -- 3.9

-- TRUNCATE直接截断
SELECT TRUNCATE(3.87,1);-- 3.8
SELECT TRUNCATE(3.8788,0);-- 3


-- 取模，幂运算
SELECT MOD(10,3);-- 1
SELECT POWER(2,4);-- 16
SELECT POW(2,4);-- 16
SELECT POW(16,1/2);-- 4 --相当于开n方,相当于下边的
SELECT SQRT(16);-- 4



