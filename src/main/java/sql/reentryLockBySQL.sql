-- MYSQl实现重入锁
CREATE TABLE `t_lock` (
                          `id` INT AUTO_INCREMENT PRIMARY KEY,
                          `lock_name` VARCHAR(255) NOT NULL,
                          `holder_thread` VARCHAR(255),
                          `reentry_cnt` INT DEFAULT 0,
                          UNIQUE KEY `uk_lock_name` (`lock_name`)
);


-- 加锁


-- 尝试加锁
SET @thread_id = 'thread-1';
SET @lock_name = 'my_lock';

-- 尝试插入（第一次加锁）
INSERT INTO t_lock(lock_name, holder_thread, reentry_cnt)
VALUES(@lock_name, @thread_id, 1)
ON DUPLICATE KEY UPDATE
                     -- 如果是同一个线程，reentry_cnt++
                     reentry_cnt = IF(holder_thread = @thread_id, reentry_cnt + 1, reentry_cnt),
                     holder_thread = IF(holder_thread = @thread_id, holder_thread, holder_thread);


-- 解锁
-- 开启事务
START TRANSACTION;
UPDATE t_lock
SET reentry_cnt = reentry_cnt - 1
WHERE lock_name = @lock_name AND holder_thread = @thread_id;

-- 如果计数为0，删除锁
DELETE FROM t_lock
WHERE lock_name = @lock_name AND reentry_cnt <= 0;

-- 提交事务
COMMIT;