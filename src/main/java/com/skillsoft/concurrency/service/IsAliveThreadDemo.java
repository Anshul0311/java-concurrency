package com.skillsoft.concurrency.service;

public class IsAliveThreadDemo {

    public static class Walk implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am walking.. My isAlive state is .." + Thread.currentThread().isAlive());
            }
        }
    }

    public void isAliveDemo() {
        Thread walkThread = new Thread(new IsAliveThreadDemo.Walk());
        System.out.println("isAlive of the walk thread after init.. " + walkThread.isAlive());
        try {
            walkThread.start();
            System.out.println("isAlive of the walk thread after start.. " + walkThread.isAlive());

            walkThread.join();
            System.out.println("isAlive of the walk thread after join.. " + walkThread.isAlive());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
