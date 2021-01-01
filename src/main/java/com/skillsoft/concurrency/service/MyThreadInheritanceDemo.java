package com.skillsoft.concurrency.service;

public class MyThreadInheritanceDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is in running state");
    }

    public void threadInheritanceDemo() {
        MyThreadInheritanceDemo myThread = new MyThreadInheritanceDemo();
        myThread.start();

        System.out.println("myThread instanceof Runnable ? " + (myThread instanceof Runnable));
        System.out.println("myThread instanceof Thread ? " + (myThread instanceof Thread));
        System.out.println("myThread instanceof Object ? " + (myThread instanceof Object));
    }
}
