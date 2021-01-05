package com.skillsoft.concurrency.service.trylock;

public class TaskOne implements Runnable{

    Resource1 resourceOne;
    Resource2 resourceTwo;

    public TaskOne(Resource1 resourceOne, Resource2 resourceTwo) {
        this.resourceOne = resourceOne;
        this.resourceTwo = resourceTwo;
    }

    @Override
    public void run() {
        try {
            boolean r1LockAcquired = resourceOne.r1Lock.tryLock();
            if (r1LockAcquired) {
                System.out.println("Lock acquired on ResourceOne by " + Thread.currentThread().getName());
                resourceOne.myVar++;
                Thread.sleep(1000);
                resourceOne.r1Lock.unlock();
                System.out.println("Lock released on ResourceOne by " + Thread.currentThread().getName());
            }

            boolean r2LockAcquired = resourceTwo.r2Lock.tryLock();
            if(r2LockAcquired) {
                System.out.println("Lock acquired on ResourceTwo by " + Thread.currentThread().getName());
                resourceTwo.myVar--;
                Thread.sleep(1000);
                resourceTwo.r2Lock.unlock();
                System.out.println("Lock released on ResourceTwo by " + Thread.currentThread().getName());
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
