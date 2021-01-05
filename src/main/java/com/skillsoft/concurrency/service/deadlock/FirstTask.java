package com.skillsoft.concurrency.service.deadlock;

public class FirstTask implements Runnable {

    ResourceOne resourceOne;
    ResourceTwo resourceTwo;

    @Override
    public void run() {
        try {
            synchronized (resourceOne) {
                System.out.println("Lock acquired on ResourceOne by " + Thread.currentThread().getName());
                resourceOne.varOne++;
                Thread.sleep(1000);
                synchronized (resourceTwo) {
                    System.out.println("Lock acquired on ResourceTwo by " + Thread.currentThread().getName());
                    resourceTwo.varTwo--;
                    Thread.sleep(1000);
                }
                System.out.println("Lock released on ResourceTwo by " + Thread.currentThread().getName());
            }
            System.out.println("Lock released on ResourceOne by " + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
