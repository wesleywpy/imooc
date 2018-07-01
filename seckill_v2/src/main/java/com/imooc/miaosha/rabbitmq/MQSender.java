package com.imooc.miaosha.rabbitmq;

import com.imooc.miaosha.config.RabbitMqConfig;
import com.imooc.miaosha.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMiaoshaMessage(MiaoshaMessage mm) {
        String msg = RedisService.beanToString(mm);
        log.info("send message {}", msg);
        amqpTemplate.convertAndSend(RabbitMqConfig.MIAOSHA_QUEUE, msg);
    }

}
