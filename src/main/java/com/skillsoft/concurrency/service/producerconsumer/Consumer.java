package com.skillsoft.concurrency.service.producerconsumer;

public class Consumer implements Runnable {

    private SharedQueue sharedQueue;
    private int consumerCapacity;
    private String consumerName;
    private String[] items = {"ItemOne", "ItemTwo", "ItemThree", "ItemFour", "ItemFive", "ItemSix", "ItemSeven", "ItemEight", "ItemNine", "ItemTen"};

    public Consumer(SharedQueue sharedQueue, String name, int capacity) {
        this.sharedQueue = sharedQueue;
        this.consumerCapacity = capacity;
        this.consumerName = name;
    }

    public void consume() throws InterruptedException {
        synchronized (sharedQueue) {
            if(sharedQueue.getQueue().size() == 0) {
                System.out.println("Queue is empty.. " + consumerName + " is waiting");
                sharedQueue.wait();
                System.out.println(consumerName + " has woken up");
            }
        }

        synchronized (sharedQueue) {
            String item = sharedQueue.getQueue().remove();
            System.out.println("Consumer : " + consumerName + " has consumed an item : " + item);
            sharedQueue.notify();
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < consumerCapacity; i++) {
            try {
                //The reason for this scenario is simulating a real-life scenario, where rate of production/consumption is not constant
                Thread.sleep((long)(Math.random() * 1000) * 5);
                consume();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Consumer has run its course .. ");
    }
}
