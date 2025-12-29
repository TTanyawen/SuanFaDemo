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