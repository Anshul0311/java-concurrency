package com.skillsoft.concurrency.service.deadlock;

public class SecondTask implements Runnable {

    ResourceOne resourceOne;
    ResourceTwo resourceTwo;

    public SecondTask(ResourceOne resourceOne, ResourceTwo resourceTwo) {
        this.resourceOne = resourceOne;
        this.resourceTwo = resourceTwo;
    }

    @Override
    public void run() {
        try {
            //We can avoid the deadlock , if it would have acquired resource-1, then atleast one of the thread would have acquired resource-1
            synchronized (resourceTwo) {
                System.out.println("Lock acquired on ResourceTwo by " + Thread.currentThread().getName());
                resourceTwo.varTwo++;
                Thread.sleep(1000);
                synchronized (resourceOne) {
                    System.out.println("Lock acquired on ResourceOne by " + Thread.currentThread().getName());
                    resourceOne.varOne--;
                    Thread.sleep(1000);
                }
                System.out.println("Lock released on ResourceOne by " + Thread.currentThread().getName());
            }
            System.out.println("Lock released on ResourceTwo by " + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
