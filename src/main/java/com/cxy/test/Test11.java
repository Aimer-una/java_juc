package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test11")
public class Test11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("洗水壶");
            try {
                Thread.sleep(1000);
                log.debug("烧水");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"施贝贝");

        Thread t2 = new Thread(()->{
            log.debug("洗茶壶");
            try {
                Thread.sleep(1000);
                log.debug("洗茶杯");
                Thread.sleep(2000);
                log.debug("拿茶叶");
                Thread.sleep(1000);
                t1.join();
                log.debug("泡茶");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"张润");
        t1.start();
        t2.start();
    }
}
