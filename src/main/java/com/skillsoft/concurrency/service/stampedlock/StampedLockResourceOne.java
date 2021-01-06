package com.skillsoft.concurrency.service.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockResourceOne {
    public int myVar = 100;
    StampedLock r1Lock = new StampedLock();
}
