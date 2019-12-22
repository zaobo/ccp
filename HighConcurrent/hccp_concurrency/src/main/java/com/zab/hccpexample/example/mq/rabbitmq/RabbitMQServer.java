package com.zab.hccpexample.example.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQServer {

    @RabbitListener(queues = QueueConstants.TEST)
    public void receive(String msg) {
        log.info("{}", msg);
    }

}
