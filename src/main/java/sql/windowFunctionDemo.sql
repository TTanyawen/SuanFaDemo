CREATE TABLE student_score (
                               stu_id INT NOT NULL COMMENT '学生ID',
                               subject_id INT NOT NULL COMMENT '科目ID',
                               score DECIMAL(5,2) NOT NULL COMMENT '成绩',
                               PRIMARY KEY (stu_id, subject_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生成绩表';

INSERT INTO student_score (stu_id, subject_id, score) VALUES
                                                          (1, 1, 90),
                                                          (1, 2, 85),
                                                          (1, 3, 88),
                                                          (2, 1, 75),
                                                          (2, 2, 80),
                                                          (2, 3, 70),
                                                          (3, 1, 95),
                                                          (3, 2, 90),
                                                          (3, 3, 92),
                                                          (4, 1, 60),
                                                          (4, 2, 70),
                                                          (4, 3, 65),
                                                          (5, 1, 88),
                                                          (5, 2, 82),
                                                          (5, 3, 85),
                                                          (6, 1, 92),
                                                          (6, 2, 87),
                                                          (6, 3, 90),
                                                          (7, 1, 78),
                                                          (7, 2, 80),
                                                          (7, 3, 75),
                                                          (8, 1, 85),
                                                          (8, 2, 88),
                                                          (8, 3, 90),
                                                          (9, 1, 70),
                                                          (9, 2, 75),
                                                          (9, 3, 72),
                                                          (10, 1, 95),
                                                          (10, 2, 92),
                                                          (10, 3, 90);

SELECT stu_id, total_score
FROM (
         SELECT
             stu_id,
             SUM(score) AS total_score,
             RANK() OVER (ORDER BY SUM(score) DESC) AS rnk
         FROM student_score
         GROUP BY stu_id
     ) t
WHERE rnk <= 10 and rnk>=5;

SELECT stu_id, subject_id, score,
       RANK() OVER (PARTITION BY subject_id ORDER BY score DESC) AS subject_rnk
FROM student_score;

SELECT *
FROM (
         SELECT stu_id, subject_id, score,
                RANK() OVER (PARTITION BY subject_id ORDER BY score DESC) AS rnk
         FROM student_score
     ) t
WHERE rnk <= 3;

SELECT stu_id, SUM(score) AS total_score,
       SUM(SUM(score)) OVER (ORDER BY stu_id) AS running_total
FROM student_score
GROUP BY stu_id
ORDER BY stu_id;

SELECT stu_id, subject_id, score,
       LAG(score) OVER (PARTITION BY subject_id ORDER BY score DESC) AS prev_score,
       score - LAG(score) OVER (PARTITION BY subject_id ORDER BY score DESC) AS diff_prev
FROM student_score;

SELECT stu_id, subject_id, score,
       PERCENT_RANK() OVER (PARTITION BY subject_id ORDER BY score DESC) AS pct_rank
FROM student_score;


-- 练习
CREATE TABLE sales (
                       sale_id INT AUTO_INCREMENT PRIMARY KEY,
                       emp_id INT NOT NULL COMMENT '销售员工ID',
                       dept_id INT NOT NULL COMMENT '部门ID',
                       sale_date DATE NOT NULL COMMENT '销售日期',
                       amount DECIMAL(10,2) NOT NULL COMMENT '销售金额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='销售记录表';
INSERT INTO sales (emp_id, dept_id, sale_date, amount) VALUES
                                                           (1, 1, '2025-01-01', 500.00),
                                                           (1, 1, '2025-01-02', 700.00),
                                                           (1, 1, '2025-01-03', 600.00),
                                                           (2, 1, '2025-01-01', 300.00),
                                                           (2, 1, '2025-01-03', 400.00),
                                                           (3, 1, '2025-01-02', 800.00),
                                                           (3, 1, '2025-01-03', 700.00),
                                                           (4, 2, '2025-01-01', 400.00),
                                                           (4, 2, '2025-01-02', 500.00),
                                                           (5, 2, '2025-01-01', 600.00),
                                                           (5, 2, '2025-01-03', 550.00),
                                                           (6, 2, '2025-01-02', 300.00),
                                                           (6, 2, '2025-01-03', 400.00),
                                                           (7, 3, '2025-01-01', 1000.00),
                                                           (7, 3, '2025-01-03', 1200.00),
                                                           (8, 3, '2025-01-02', 800.00),
                                                           (8, 3, '2025-01-03', 900.00);

-- 计算每个员工按日期的累计销售额（Running Total），显示 emp_id、sale_date、amount、累计销售额。
select emp_id,sale_date,amount,
       SUM(amount) OVER (PARTITION BY emp_id ORDER BY sale_date) as running_amount
from sales;

-- 按部门统计每个员工总销售额，并给部门内排名，显示 dept_id、emp_id、总销售额、排名

    -- gpt给的答案
-- select dept_id,emp_id,
-- 	totalAmount,
-- 	RANK() OVER (PARTITION BY dept_id order by totalAmount DESC) as dept_rank
-- from (
-- 	SELECT emp_id,dept_id,SUM(amount) as totalAmount
-- 	from sales
-- 	GROUP BY emp_id,dept_id
-- )t
-- order by dept_id,dept_rank;

-- 我的答案-也ok
select emp_id,dept_id,
       sum(amount),
       RANK() OVER (PARTITION BY dept_id order by sum(amount) DESC) as dept_rank
from sales
GROUP BY emp_id,dept_id
order by dept_id,dept_rank;


