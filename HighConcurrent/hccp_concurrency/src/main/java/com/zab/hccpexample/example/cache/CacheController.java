package com.zab.hccpexample.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisClient redisClient;

    @PostMapping("set")
    public String set(@RequestParam String key, @RequestParam String value) throws Exception {
        redisClient.set(key, value);
        return "SUCCESS";
    }

    @GetMapping("get")
    public String set(@RequestParam String key) throws Exception {
        return redisClient.get(key);
    }

}
