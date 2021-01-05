package com.skillsoft.concurrency.service.explicitlocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceOne {

    public int varOne = 100;
    Lock r1Lock = new ReentrantLock();
}
