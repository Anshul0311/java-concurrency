package com.skillsoft.concurrency.service.producerconsumer;

import java.util.LinkedList;

public class ProducerConsumerDemo {
    public void demo() {
        SharedQueue sharedQueue = new SharedQueue(new LinkedList<>(), 2);
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue, "ConsumerOne", 10);
        Thread p = new Thread(producer, "Producer Thread");
        Thread c = new Thread(consumer, "Consumer Thread");

        p.start();
        c.start();
    }
}
