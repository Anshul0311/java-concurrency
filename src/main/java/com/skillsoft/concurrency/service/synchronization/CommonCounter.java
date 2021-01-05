package com.skillsoft.concurrency.service.synchronization;

public class CommonCounter {

    private int count = 0;

    public synchronized void incrementCounter() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
