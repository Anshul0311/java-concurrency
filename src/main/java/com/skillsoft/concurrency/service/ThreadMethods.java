package com.skillsoft.concurrency.service;

public class ThreadMethods {

    public static class Walk implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am walking.. ");
            }
        }
    }

    public static class ChewGum implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am chewing gum..");
            }
        }
    }

    public void threadMethodsDemo() {
        Thread walkThread = new Thread(new ThreadMethods.Walk());
        Thread chewThread = new Thread(new ThreadMethods.ChewGum());

        walkThread.start();
        chewThread.start();

        System.out.println("\nwalk thread's id : " + walkThread.getId());
        System.out.println("chew thread's id : " + chewThread.getId());
        System.out.println("main thread's id : " + Thread.currentThread().getId());

        System.out.println("\nwalk thread's name : " + walkThread.getName());
        System.out.println("chew thread's name : " + chewThread.getName());
        System.out.println("main thread's name : " + Thread.currentThread().getName());

        System.out.println("\nwalk thread's group : " + walkThread.getThreadGroup());
        System.out.println("chew thread's group : " + chewThread.getThreadGroup());
        System.out.println("main thread's group : " + Thread.currentThread().getThreadGroup());

        System.out.println("\nwalk thread's priority : " + walkThread.getPriority());
        System.out.println("chew thread's priority : " + chewThread.getPriority());
        System.out.println("main thread's priority : " + Thread.currentThread().getPriority());

        System.out.println("#Active Threads Count " + Thread.activeCount());
        System.out.println("\n\n");
    }

}
