package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test7")
public class Test7 {
   static int i1 = 0;
   static int i2 = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
                i1 = 10;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(2000);
                i2 = 20;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        long begin = System.currentTimeMillis();
        log.debug("....");
        t2.join();
        log.debug("t2join");
        t1.join();
        log.debug("t1join");
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", i1, i2, end - begin);
    }

}
