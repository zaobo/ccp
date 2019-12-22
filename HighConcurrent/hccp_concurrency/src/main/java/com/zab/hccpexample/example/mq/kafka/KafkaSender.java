package com.zab.hccpexample.example.mq.kafka;

import com.alibaba.fastjson.JSON;
import com.zab.hccpexample.example.mq.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Slf4j
public class KafkaSender {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String msg) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        log.info("send Message:{}", message);
        kafkaTemplate.send(TopicConstants.TEST, JSON.toJSONString(message));
    }

}
