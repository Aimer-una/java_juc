package com.cxy.test;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
@Slf4j(topic = "c.Test12")
public class Test12 {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(()->{
                queue.put(new Message(id,"值"+id));
            },"生产者"+i).start();
        }

        new Thread(()->{
            while (true){
                Message message = queue.take();
            }
        },"消费者").start();
    }
}
@Slf4j(topic = "c.MessageQueue")
class MessageQueue{
    // 消息队列的集合
    LinkedList<Message> list = new LinkedList<>();
    // 消息队列容量
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    // 获取消息
    public Message take(){
        // 检查队列是否为空
        synchronized (list) {
            while (list.isEmpty()){
                try {
                    log.debug("队列为空，消费者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 从队列头部获取消息并且返回
            Message message = list.removeFirst();
            log.debug("消费者消息已消费{}",message);
            list.notifyAll();
            return message;
        }

    }

    // 存取消息
    public void put(Message message){
        // 检查队列是否满了
        synchronized (list){
            while (list.size() == capacity){
                try {
                    log.debug("队列已满，生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(message);
            log.debug("生产者消息已生成{}",message);
            list.notifyAll();
        }

    }
}
@Slf4j(topic = "c.Message")
final class Message{
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
