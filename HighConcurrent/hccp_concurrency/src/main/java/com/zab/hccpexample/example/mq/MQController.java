package com.zab.hccpexample.example.mq;

import com.zab.hccpexample.example.mq.kafka.KafkaSender;
import com.zab.hccpexample.example.mq.rabbitmq.RabbitMQClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("mq")
public class MQController {

    @Resource
    private RabbitMQClient rabbitMQClient;
    @Resource
    private KafkaSender kafkaSender;

    @RequestMapping("send")
    public String send(@RequestParam String msg) {
        rabbitMQClient.send(msg);
        kafkaSender.send(msg);
        return "SUCCESS";
    }

}
