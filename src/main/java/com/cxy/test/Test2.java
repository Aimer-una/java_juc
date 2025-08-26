package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setName("施贝贝");
        thread.start();
    }
}
