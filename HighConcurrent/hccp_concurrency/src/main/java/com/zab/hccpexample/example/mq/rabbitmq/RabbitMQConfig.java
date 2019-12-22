package com.zab.hccpexample.example.mq.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /**
     * 指定队列
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QueueConstants.TEST);
    }

}
