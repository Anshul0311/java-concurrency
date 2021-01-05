package com.skillsoft.concurrency.service.trylock;

public class TryLockDemo {
    public void tryLockDemo() {
        Resource1 resourceOne = new Resource1();
        Resource2 resourceTwo = new Resource2();

        Thread threadOne = new Thread(new TaskOne(resourceOne, resourceTwo), "firstTask");
        Thread threadTwo = new Thread(new TaskTwo(resourceOne, resourceTwo), "secondTask");

        System.out.println("Starting the two threads..");
        try {
            threadOne.start();
            threadTwo.start();

            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
