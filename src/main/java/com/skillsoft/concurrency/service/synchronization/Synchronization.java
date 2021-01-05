package com.skillsoft.concurrency.service.synchronization;

public class Synchronization {

    private static final int NUM_ITERATIONS = 1000;

    public void synchronizationDemo() {
        CommonCounter commonCounter = new CommonCounter();
        //CommonCounter , a shared resource is passed for all threads
        Thread threadOne = new Thread(new CounterIncrementor(commonCounter,NUM_ITERATIONS));
        Thread threadTwo = new Thread(new CounterIncrementor(commonCounter,NUM_ITERATIONS));
        System.out.println("Start value of count is : " + commonCounter.getCount());
        try {
            threadOne.start();
            threadTwo.start();

            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("End value of count is : " + commonCounter.getCount());
    }
}
