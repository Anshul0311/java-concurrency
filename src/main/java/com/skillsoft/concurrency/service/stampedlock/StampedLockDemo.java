package com.skillsoft.concurrency.service.stampedlock;

public class StampedLockDemo {
    public void stampedLockDemo() {
        StampedLockResourceOne resourceOne = new StampedLockResourceOne();
        StampedLockResourceTwo resourceTwo = new StampedLockResourceTwo();

        Thread threadOne = new Thread(new StampedTaskOne(resourceOne, resourceTwo), "firstTask");
        Thread threadTwo = new Thread(new StampedTaskTwo(resourceOne, resourceTwo), "secondTask");
        Thread threadThree = new Thread(new StampedTaskTwo(resourceOne, resourceTwo), "anotherSecondTask");

        System.out.println("Starting the three threads..");
        System.out.println("Starting value of resources " + resourceOne.myVar + " " + resourceTwo.myVar);
        try {
            threadOne.start();
            threadTwo.start();
            threadThree.start();

            threadOne.join();
            threadTwo.join();
            threadThree.join();

            System.out.println("Ending the three threads..");
            System.out.println("Ending value of resources " + resourceOne.myVar + " " + resourceTwo.myVar);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
