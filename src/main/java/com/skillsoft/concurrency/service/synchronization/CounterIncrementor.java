package com.skillsoft.concurrency.service.synchronization;

public class CounterIncrementor implements Runnable {

    private CommonCounter commonCounter;
    private int numIterations;

    public CounterIncrementor(CommonCounter commonCounter, int numIterations) {
        this.commonCounter = commonCounter;
        this.numIterations = numIterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < numIterations; i++) {
            commonCounter.incrementCounter();
        }
    }
}
