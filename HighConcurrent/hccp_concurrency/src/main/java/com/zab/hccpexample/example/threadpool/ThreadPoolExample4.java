package com.zab.hccpexample.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

//        executorService.schedule(()->{
//            log.warn("schedule");
//        }, 3, TimeUnit.SECONDS);

        // 以指定的速率去执行该任务
        executorService.scheduleAtFixedRate(()->{
            log.warn("scheduleAtFixedRate");
        }, 1, 3, TimeUnit.SECONDS);// 1表示延迟执行，每隔三秒重复执行，此时不适合关闭线程池，如果关闭了，就不会周期性的重复执行了

//        executorService.shutdown();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(),5000);//5000是每个5秒重复执行
    }

}
