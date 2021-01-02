package com.skillsoft.concurrency.service;

public class ConcurrentThreads implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " says: " + i);
        }
    }

    public void concurrentDemo() throws InterruptedException {
        Thread t1 = new Thread(new ConcurrentThreads());
        Thread t2 = new Thread(new ConcurrentThreads());
        t1.start();
        t2.start();

        //t1.start() won't work
        //t1.run() will work
        //Thread t1 = new Thread(new ConcurrentThreads(), "1st thread"); Naming the thread
    }
}
