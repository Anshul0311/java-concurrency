package com.skillsoft.concurrency.service.synchronization;

public class SynchronisationExample2 {
    private static final int NUM_ITERATIONS = 1000;

    public void synchronizationDemo() {
        CommonCounter commonCounterOne = new CommonCounter();
        CommonCounter commonCounterTwo = new CommonCounter();
        //CommonCounter , a shared resource is passed for all threads
        Thread threadOne = new Thread(new CounterIncrementor(commonCounterOne, NUM_ITERATIONS));
        Thread threadTwo = new Thread(new CounterIncrementor(commonCounterTwo, NUM_ITERATIONS));
        Thread threadThree = new Thread(new CounterIncrementor(commonCounterTwo, NUM_ITERATIONS));
        System.out.println("Start value of count-1 is : " + commonCounterOne.getCount());
        System.out.println("Start value of count-2 s : " + commonCounterTwo.getCount());
        try {
            threadOne.start();
            threadTwo.start();
            threadThree.start();

            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("End value of count-1 is : " + commonCounterOne.getCount());
        System.out.println("End value of count-2 is : " + commonCounterOne.getCount());
    }
}
