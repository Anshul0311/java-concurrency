package com.skillsoft.concurrency.service.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource2 {
    public int myVar = 1000;
    Lock r2Lock = new ReentrantLock();
}
