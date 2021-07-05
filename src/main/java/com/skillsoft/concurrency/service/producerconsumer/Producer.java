package com.skillsoft.concurrency.service.producerconsumer;

public class Producer implements Runnable {

    private SharedQueue sharedQueue;
    private String[] items = {"ItemOne", "ItemTwo", "ItemThree", "ItemFour", "ItemFive", "ItemSix", "ItemSeven", "ItemEight", "ItemNine", "ItemTen"};

    public Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void produce(String item) throws InterruptedException {
        synchronized (sharedQueue) {
            if(sharedQueue.getQueue().size() >= sharedQueue.getCapacity()) {
                System.out.println("Queue is full.. Producer is waiting");
                sharedQueue.wait();
                System.out.println("Producer has woken up");
            }
        }

        synchronized (sharedQueue) {
            sharedQueue.getQueue().add(item);
            System.out.println("Produced : " + item);
            sharedQueue.notify();
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < items.length; i++) {
            try {
                //The reason for this scenario is simulating a real-life scenario, where rate of production/consumption is not constant
                Thread.sleep((long)(Math.random() * 1000) * 5);
                produce(items[i]);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Producer has run its course .. ");
    }
}
