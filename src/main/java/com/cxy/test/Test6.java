package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test6 {
   static int i = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread (()->{
            log.debug("启动");
            try {
                Thread.sleep(1000);
                i = 10;
                log.debug("结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t1.join();
        // join方法等调用线程执行完之后再执行主线程
        System.out.println(i);
    }
}
