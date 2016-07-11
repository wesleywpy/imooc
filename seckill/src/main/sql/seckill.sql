-- 执行秒杀存储过程
-- row_count():返回上一条修改类型的sql(delete,update,insert)的影响行数
-- row_count(): 0:未修改数据;>0 :表示修改的行数;<0:sql错误/未执行修改的sql
DELIMITER $$ -- ; 转换为 $$

CREATE PROCEDURE `wesley`.`execute_seckill`
  (IN `v_seckill_id` bigint,IN `v_phone` bigint,IN `v_kill_time` timestamp,OUT `r_result` int)
BEGIN
	DECLARE insert_count INT DEFAULT 0;
	START TRANSACTION;

	#先插入成功秒杀记录
	INSERT IGNORE INTO success_killed(seckill_id, user_phone, state, create_time) VALUES (v_seckill_id, v_phone, 1, v_kill_time);

	SELECT ROW_COUNT() INTO insert_count;
	IF (insert_count = 0) THEN
		ROLLBACK;
		SET r_result = -1;
	ELSEIF (insert_count < 0) THEN
		ROLLBACK;
		SET r_result = -2;

	ELSE
		UPDATE seckill SET number = number - 1 WHERE id = v_seckill_id
			AND end_time > v_kill_time AND start_time < v_kill_time AND number > 0;
		SELECT ROW_COUNT() INTO insert_count;

		IF (insert_count <= 0) THEN
			ROLLBACK;
			set r_result = -2;
		ELSE
			COMMIT;
			SET r_result = 1;
		END IF;
	END IF;
END;
$$


-- 存储过程定义

DELIMITER  ;
set @r_result=-3;
-- 执行存储过程
call execute_seckill(1004,15821112222,now(),@r_result);

-- 获取结果
SELECT  @r_result;

show create procedure execute_seckill\G

-- 存储过程
-- 存储过程优化的是事务行级锁持有的时间
-- 不要过度依赖存储过程, 简单的逻辑可以应用存储过程
