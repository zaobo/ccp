package com.zab.hccpexample;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class MapExample {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static Map<Integer, Integer> map = new HashMap();

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int n = i;
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    put(n);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }

        service.shutdown();
        log.info("size:{}", map.size());
    }

    private static void put(Integer i) {
        map.put(i, i);
    }

}
