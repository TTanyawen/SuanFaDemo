/**
  1. 创建两个表user 和orders
  2. 写exist和in分别查到状态正常的用户的订单

  **/
CREATE TABLE `user`(
                       `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                       `username` VARCHAR(50) NOT NULL COMMENT '用户名',
                       `status` TINYINT NOT NULL DEFAULT 1 COMMENT '1正常，0禁用'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `orders` (
                          `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
                          `user_id` BIGINT NOT NULL COMMENT '下单用户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

INSERT INTO `user` (`username`, `status`) VALUES
                                              ('alice', 1),
                                              ('bob', 1),
                                              ('carol', 0),
                                              ('dave', 1),
                                              ('eve', 0),
                                              ('frank', 1),
                                              ('grace', 1),
                                              ('heidi', 0),
                                              ('ivan', 1),
                                              ('judy', 1);
INSERT INTO `orders` (`user_id`) VALUES
                                     (1),
                                     (2),
                                     (3),
                                     (3),
                                     (4),
                                     (5),
                                     (6),
                                     (7),
                                     (8),
                                     (10);


-- 对于o表的每一行都去判断，下面的select语句是否有结果
-- 对于每一行数据，是否能使得子查询返回至少一行数据，能的话就是True，否则是false
select *
from orders o
where exists(
    select 1
    from `user` u
    where u.id=o.user_id
      and u.status=1
);

-- IN 左边的表达式(o.user_id)在右边的结果集(单列的结果集)中
select *
from orders o
where o.user_id in(
    select id
    from `user` u
    where u.status=1
);

select *
from user u
where u.username IN('alice','ivan');


-- 性能：
-- 从执行策略来看
-- EXIST是一行行去user看有没有存在的数据
-- IN是先把user过滤一遍形成一个子集合，然后对于order的每一行再去看在不在子集合中
-- 如果user表很小，过滤后的user子集合更小，就适合用IN
-- 如果order表和user表很大，user表过滤后也不见得有多小，就适合用EXIST
-- 普遍来讲，用EXIST会比较好，因为它找到了一条数据符合的就会“短路”返回true


-- NULL的处理
-- IN: Null与任何值比较返回 false,即便是null和null
-- NULL==1 -> unknown ->false
-- NULL==2 -> unknown ->false
-- NULL==NULL -> unknown ->false
select 1 where 1 in (1, 2);
select 1 where null in (1, 2, null);

-- EXIST只关心有没有结果，不关心结果是不是null
-- 如果你考虑保留null，请用EXIST
select 1 where exists(
    select NULL
)-- 这里select NULL表示一行结果，所以上层会返回1行值为1的结果

