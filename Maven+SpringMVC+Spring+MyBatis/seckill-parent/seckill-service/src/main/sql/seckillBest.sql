DELIMITER //
CREATE PROCEDURE executeSeckill(IN fadeSeckillId INT,IN fadeUserPhone VARCHAR (15),IN fadeKillTime TIMESTAMP ,OUT fadeResult INT)
  BEGIN
    DECLARE insertCount INT DEFAULT 0;
    START TRANSACTION ;
    INSERT IGNORE success_killed(seckill_id,user_phone,state,create_time) VALUES(fadeSeckillId,fadeUserPhone,0,fadeKillTime);  --先插入购买明细
    SELECT ROW_COUNT() INTO insertCount;
    IF(insertCount = 0) THEN
      ROLLBACK ;
      SET fadeResult = -1;   --重复秒杀
    ELSEIF(insertCount < 0) THEN
      ROLLBACK ;
      SET fadeResult = -2;   --内部错误
    ELSE   --已经插入购买明细，接下来要减少库存
      UPDATE seckill SET number = number -1 WHERE seckill_id = fadeSeckillId AND start_time < fadeKillTime AND end_time > fadeKillTime AND number > 0;
      SELECT ROW_COUNT() INTO insertCount;
      IF (insertCount = 0)  THEN
        ROLLBACK ;
        SET fadeResult = 0;   --库存没有了，代表秒杀已经关闭
      ELSEIF (insertCount < 0) THEN
        ROLLBACK ;
        SET fadeResult = -2;   --内部错误
      ELSE
        COMMIT ;    --秒杀成功，事务提交
        SET  fadeResult = 1;   --秒杀成功返回值为1
      END IF;
    END IF;
  END
//

DELIMITER ;

SET @fadeResult = -3;
CALL executeSeckill(8,11111111111,NOW(),@fadeResult);
SELECT @fadeResult;
