package com.skillsoft.concurrency.service.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource1 {
    public int myVar = 100;
    Lock r1Lock = new ReentrantLock();
}
