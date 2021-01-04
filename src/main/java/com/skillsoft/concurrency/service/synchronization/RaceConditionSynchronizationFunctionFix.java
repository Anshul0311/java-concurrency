package com.skillsoft.concurrency.service.synchronization;

public class RaceConditionSynchronizationFunctionFix implements Runnable {

    private static int myNumShared;

    private static final int INC_ITERATIONS = 10000;

    public static class CommonCounterSynchronized {
        public static synchronized void incrementSharedCounter() {
            myNumShared++;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < INC_ITERATIONS; i++) {
            CommonCounterSynchronized.incrementSharedCounter();
        }
    }

    public void synchronizationDemo() {
        Thread threadOne = new Thread(new RaceConditionSynchronizationFunctionFix());
        Thread threadTwo = new Thread(new RaceConditionSynchronizationFunctionFix());
        System.out.println("Start value of myNum is : " + myNumShared);
        try {
            threadOne.start();
            threadTwo.start();

            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("End value of myNum is : " + myNumShared);
    }
}
