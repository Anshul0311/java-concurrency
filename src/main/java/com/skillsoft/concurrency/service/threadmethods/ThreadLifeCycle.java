package com.skillsoft.concurrency.service.threadmethods;

public class ThreadLifeCycle {

    //There will be a single instance of Walk class for the entire thread lifecycle, since its a static class
    public static class Walk implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am walking..");
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

    public void performTasks() {
        Thread walkThread = new Thread(new Walk());
        Thread chewThread = new Thread(new ChewGum());
        try {
            walkThread.start();
            walkThread.join();
            chewThread.start();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
