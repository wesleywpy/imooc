-- 描述库存表
-- mysql　Ver　5.7.12 中一个表只能有一个TIMESTAMP
CREATE TABLE seckill(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品秒杀Id',
  `name` VARCHAR(100) NOT NULL COMMENT '商品名称',
  `number` BIGINT NOT NULL COMMENT '库存数量',
  `start_time` DATETIME NOT NULL COMMENT '秒杀开始时间',
  `end_time` DATETIME NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  PRIMARY KEY (id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT '描述库存表';

-- 初始化数据
INSERT INTO seckill (name, number, start_time, end_time) VALUES ('1000秒杀iPhone6 Plus', 10, '2016-05-08 22:34:49', '2016-05-09 23:59:59');
INSERT INTO seckill (name, number, start_time, end_time) VALUES ('50秒杀桌游 萨薄传奇', 20, '2016-05-10 22:34:49', '2016-05-10 23:59:59');
INSERT INTO seckill (name, number, start_time, end_time) VALUES ('100秒杀kindle', 10, '2016-05-10 22:34:49', '2016-05-15 23:59:59');


-- 用户成功秒杀明细表
CREATE TABLE success_seckill(
  seckill_id BIGINT NOT NULL COMMENT '秒杀Id',
  user_phone BIGINT NOT NULL COMMENT '用户手机号，唯一识别',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态说明: -1无效 0 成功 1已付款 2已发货',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone),
  KEY idx_create_time(create_time)
)