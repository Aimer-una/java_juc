package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test4")
public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread("施贝贝"){
            @Override
            public void run() {
                log.debug("running...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();
        log.debug("睡眠前状态:{}",t1.getState());
        log.debug("睡眠后状态:{}",t1.getState());
    }
}
