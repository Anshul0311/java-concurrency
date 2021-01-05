package com.skillsoft.concurrency.service.explicitlocking;

public class FirstTask implements Runnable {

    ResourceOne resourceOne;
    ResourceTwo resourceTwo;

    public FirstTask(ResourceOne resourceOne, ResourceTwo resourceTwo) {
        this.resourceOne = resourceOne;
        this.resourceTwo = resourceTwo;
    }

    @Override
    public void run() {
        try {
            resourceOne.r1Lock.lock();
            System.out.println("Lock acquired on ResourceOne by " + Thread.currentThread().getName());
            resourceOne.varOne++;
            Thread.sleep(1000);
            resourceOne.r1Lock.unlock();
            System.out.println("Lock released on ResourceOne by " + Thread.currentThread().getName());

            resourceTwo.r2Lock.lock();
            System.out.println("Lock acquired on ResourceTwo by " + Thread.currentThread().getName());
            resourceTwo.varTwo--;
            Thread.sleep(1000);
            resourceTwo.r2Lock.unlock();
            System.out.println("Lock released on ResourceTwo by " + Thread.currentThread().getName());
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
