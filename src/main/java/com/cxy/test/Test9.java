package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test9")
public class Test9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted){
                    log.debug("被打断了，循环终止");
                    break;
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();
    }
}
