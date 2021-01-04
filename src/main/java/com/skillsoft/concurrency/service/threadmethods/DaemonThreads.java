package com.skillsoft.concurrency.service.threadmethods;

public class DaemonThreads {

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

    public void daemonDemo() {
        Thread walkThread = new Thread(new ThreadMethods.Walk());
        Thread chewThread = new Thread(new ThreadMethods.ChewGum());

        chewThread.setDaemon(true);

        System.out.println("\nwalk thread's daemon status : " + walkThread.isDaemon());
        System.out.println("chew thread's daemon status : " + chewThread.isDaemon());
        System.out.println("main thread's daemon status : " + Thread.currentThread().isDaemon());

        System.out.println("\n\n");

        try {
            walkThread.start();
            walkThread.join(5000);
            chewThread.start();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
