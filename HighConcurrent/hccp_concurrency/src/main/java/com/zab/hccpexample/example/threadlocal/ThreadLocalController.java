package com.zab.hccpexample.example.threadlocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threadLocal/")
public class ThreadLocalController {

    @RequestMapping("test")
    private Long test() {
        return RequestHolder.getId();
    }

}
