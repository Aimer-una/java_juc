package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test10")
public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        TwoPhase twoPhase = new TwoPhase();
        twoPhase.start();
        Thread.sleep(3500);
        twoPhase.stop();
    }
}
@Slf4j(topic = "c.TwoPhase")
class TwoPhase{
    Thread monitor;
    // 启动监控线程
    public void start(){
        monitor = new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                if (current.isInterrupted()){
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);// 情况一
                    log.debug("执行监控记录"); // 情况二
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 重新设置打断标记
                    current.interrupt();
                }
            }
        });
    }

    public void stop(){
        monitor.interrupt();
    }
}
