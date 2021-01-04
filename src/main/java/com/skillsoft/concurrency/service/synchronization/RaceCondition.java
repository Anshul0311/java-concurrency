package com.skillsoft.concurrency.service.synchronization;

public class RaceCondition implements Runnable {

    //Given its a static int, no matter how many instances of Synchronization class are created, they will all be accessing the same myNum variable
    private static int myNum;

    //Declaring a constant with static and final
    private static final int NUM_ITERATIONS = 100;

    //The way we are updating myNum is through a CommonCounter object,so multiple instances of Synchronization class will be using the same CommonCounter object to increment myNum
    public static class CommonCounter {
        public static void incrementCounter() {
            myNum++;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            CommonCounter.incrementCounter();
        }
    }

    //Race Condition
    public void synchronisationDemo() {
        //Each of the thread will perform 10 increments of myNum variable
        Thread threadOne = new Thread(new RaceCondition());
        Thread threadTwo = new Thread(new RaceCondition());
        System.out.println("Start value of myNum is : " + myNum);
        try {
            threadOne.start();
            threadTwo.start();

            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("End value of myNum is : " + myNum);
    }
}
