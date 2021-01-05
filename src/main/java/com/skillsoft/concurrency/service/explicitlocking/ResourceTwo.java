package com.skillsoft.concurrency.service.explicitlocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceTwo {
    public int varTwo = 1000;
    Lock r2Lock = new ReentrantLock();
}
