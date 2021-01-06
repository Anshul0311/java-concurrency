package com.skillsoft.concurrency.service.stampedlock;

public class StampedTaskTwo implements Runnable {
    StampedLockResourceOne stampedLockResourceOne;
    StampedLockResourceTwo stampedLockResourceTwo;

    public StampedTaskTwo(StampedLockResourceOne stampedLockResourceOne, StampedLockResourceTwo stampedLockResourceTwo) {
        this.stampedLockResourceOne = stampedLockResourceOne;
        this.stampedLockResourceTwo = stampedLockResourceTwo;
    }

    @Override
    public void run()
    {
        try {
            long writeLockTwoStamp = stampedLockResourceTwo.r2Lock.writeLock();
            System.out.println("Lock acquired on ResourceTwo by " + Thread.currentThread().getName() + ". Lock stamp is " + writeLockTwoStamp);
            Thread.sleep(1000);
            stampedLockResourceTwo.myVar++;
            stampedLockResourceTwo.r2Lock.unlock(writeLockTwoStamp);
            System.out.println("Lock on ResourceTwo released by " + Thread.currentThread().getName());

            long writeLockOneStamp = stampedLockResourceOne.r1Lock.writeLock();
            System.out.println("Lock acquired on ResourceOne by " + Thread.currentThread().getName() + ". Lock stamp is " + writeLockOneStamp);
            Thread.sleep(1000);
            stampedLockResourceOne.myVar--;
            stampedLockResourceOne.r1Lock.unlock(writeLockOneStamp);
            System.out.println("Lock on ResourceOne released by " + Thread.currentThread().getName());
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
