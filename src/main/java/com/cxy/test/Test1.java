package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                log.debug("running");
            }
        };
        thread.setName("施贝贝");
        thread.start();

        log.debug("running");
    }
}
