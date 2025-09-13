package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;
@Slf4j(topic = "c.Test12")
public class Test13 {
   static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {

        reentrantLock.lock();
        try {
            method1();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void method1(){
        reentrantLock.lock();
        try{
            log.debug("execute method1");
            method2();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void method2(){
        reentrantLock.lock();
        try {
            log.debug("execute method2");
            method3();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void method3() {
        reentrantLock.lock();
        try {
            log.debug("execute method3");
        } finally {
            reentrantLock.unlock();
        }
    }



}
