package com.skillsoft.concurrency.service.threadmethods;

public class MyThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("This has been executed by a thread");
    }

    public void runnableDemo() {
        Thread myThread = new Thread(new MyThreadRunnable());
        myThread.start();

        System.out.println("myThread instanceof Runnable ? " + (myThread instanceof Runnable));
        System.out.println("myThread instanceof Thread ? " + (myThread instanceof Thread));
        System.out.println("myThread instanceof Object ? " + (myThread instanceof Object));
    }
}
