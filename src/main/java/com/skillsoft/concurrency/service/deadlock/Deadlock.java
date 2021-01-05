package com.skillsoft.concurrency.service.deadlock;

public class Deadlock {
    public void deadLockDemo() {
        ResourceOne resourceOne = new ResourceOne();
        ResourceTwo resourceTwo = new ResourceTwo();

        Thread threadOne = new Thread(new FirstTask(resourceOne, resourceTwo), "firstTask");
        Thread threadTwo = new Thread(new SecondTask(resourceOne, resourceTwo), "secondTask");

        System.out.println("Starting the two threads..");
        try {
            threadOne.start(); //This thread will acquire lock on resource one
            threadTwo.start(); //This thread will acquire lock on resource two

            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
