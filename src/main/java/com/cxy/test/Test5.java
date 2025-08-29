package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

// sleep打断
@Slf4j(topic = "c.Test5")
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                log.debug("running...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("wake up");
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();

    }
}
