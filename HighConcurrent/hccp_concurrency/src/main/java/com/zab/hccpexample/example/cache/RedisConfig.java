package com.zab.hccpexample.example.cache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {

    @Bean(name = "redisPool")
    public JedisPool redisPool(@Value("${redis.host}") String host,
                               @Value("${redis.port}") Integer port) {
        return new JedisPool(new GenericObjectPoolConfig(), host, port, 50, "nptqdyd668tt");
    }

}
