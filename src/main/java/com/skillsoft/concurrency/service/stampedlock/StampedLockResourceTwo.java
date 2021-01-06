package com.skillsoft.concurrency.service.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockResourceTwo {
    public int myVar = 1000;
    StampedLock r2Lock = new StampedLock();
}
