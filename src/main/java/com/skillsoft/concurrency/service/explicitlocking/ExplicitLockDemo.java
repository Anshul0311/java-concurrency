package com.skillsoft.concurrency.service.explicitlocking;

public class ExplicitLockDemo {
    public void explicitLockDemo() {
        ResourceOne resourceOne = new ResourceOne();
        ResourceTwo resourceTwo = new ResourceTwo();

        Thread threadOne = new Thread(new FirstTask(resourceOne, resourceTwo), "firstTask");
        Thread threadTwo = new Thread(new SecondTask(resourceOne, resourceTwo), "secondTask");

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
