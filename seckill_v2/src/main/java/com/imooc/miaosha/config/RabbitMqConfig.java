package com.imooc.miaosha.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by Wesley on 2018/6/29.
 */
@Configuration
public class RabbitMqConfig {

    public static final String MIAOSHA_QUEUE = "miaosha.queue";

    /**
     * Direct模式 Exchange
     */
    @Bean
    public Queue queue() {
        return new Queue(MIAOSHA_QUEUE, true);
    }
}
