package com.skillsoft.concurrency.service.threadmethods;

public class ThreadPriority {

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

    public void threadPriorityDemo() {
        Thread walkThread = new Thread(new ThreadMethods.Walk());
        Thread chewThread = new Thread(new ThreadMethods.ChewGum());

        walkThread.setPriority(9);
        chewThread.setPriority(2);

        System.out.println("\nwalk thread's priority : " + walkThread.getPriority());
        System.out.println("chew thread's priority : " + chewThread.getPriority());
        System.out.println("main thread's priority : " + Thread.currentThread().getPriority());

        walkThread.start();
        chewThread.start();

        System.out.println("\n\n");
    }
}
