package com.zab.hccpexample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class CountExample {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static long count = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        service.shutdown();
        log.info("count:{}", count);
    }

    private synchronized static void add() {
        count++;
    }

}
