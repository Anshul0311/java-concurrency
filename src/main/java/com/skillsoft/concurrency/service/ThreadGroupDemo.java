package com.skillsoft.concurrency.service;

public class ThreadGroupDemo {
    public static class Walk implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String threadGroup = Thread.currentThread().getThreadGroup().getName();
                int activeThreads = Thread.activeCount();
                System.out.println("I am walking.. My thread group " + threadGroup + "has an active count of " + activeThreads);
            }
        }
    }

    public static class ChewGum implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String threadGroup = Thread.currentThread().getThreadGroup().getName();
                int activeThreads = Thread.activeCount();
                System.out.println("I am chewing.. My thread group " + threadGroup + "has an active count of " + activeThreads);
            }
        }
    }

    public void threadMethodsDemo() {
        ThreadGroup groupOne = new ThreadGroup("GroupOne");
        ThreadGroup grouptwo = new ThreadGroup("GroupTwo");

        Thread walkThreadOne = new Thread(groupOne, new ThreadMethods.Walk());
        Thread walkThreadTwo = new Thread(grouptwo, new ThreadMethods.Walk());
        Thread walkThreadThree = new Thread(grouptwo, new ThreadMethods.Walk());

        Thread chewThreadOne = new Thread(groupOne, new ThreadMethods.ChewGum());
        Thread chewThreadTwo = new Thread(grouptwo, new ThreadMethods.ChewGum());

        walkThreadOne.start();
        walkThreadTwo.start();
        walkThreadThree.start();
        chewThreadOne.start();
        chewThreadTwo.start();

        System.out.println("#Active Threads for main " + Thread.activeCount());
        System.out.println("#Active Threads for GroupOne " + groupOne.activeCount());
        System.out.println("#Active Threads for GroupTwo " + groupOne.activeCount());
    }
}
