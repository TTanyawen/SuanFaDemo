CREATE TABLE number(
	`num` INT
)

INSERT INTO number(num)
values(1),(2),(3),(4),(5),(NULL),(1);

-- COUNT
SELECT COUNT(*) FROM number;-- 包含null -- 7
SELECT COUNT(num) FROM number;-- 不包含null  -- 6
SELECT COUNT(distinct num) FROM number;-- 去重后统计，不含null -- 5

-- SUM,AVG,MAX,MIN
SELECT SUM(num),AVG(num),MIN(num),MAX(num)
from number;


