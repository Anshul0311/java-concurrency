package com.skillsoft.concurrency.service.threadmethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ThreadInterruptDemo implements Runnable {
    private String[] urlsList;

    public ThreadInterruptDemo(String[] urlsList) {
        this.urlsList = urlsList;
    }

    @Override
    public void run() {
        try {
            for(String urlString : urlsList) {
                URL url = new URL(urlString);
                String filename = urlString.substring(urlString.lastIndexOf("/") + 1).trim() + ".html";
                BufferedReader reader =  new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
                System.out.println("Page downloaded to " + filename);
                writer.close();
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void threadInterruptDemo() {
        Thread downloaderOne = new Thread(new WebPageDonwloaderMultiThreaded(Arrays.copyOfRange(urlsList, 0, 6)));
        Thread downloaderTwo = new Thread(new WebPageDonwloaderMultiThreaded(Arrays.copyOfRange(urlsList, 6, urlsList.length)));

        try {
            Instant startTime = Instant.now();
            downloaderOne.start();
            downloaderTwo.start();

            Thread.sleep(10000);
            downloaderOne.interrupt();
            downloaderTwo.join();
            Instant endTime = Instant.now();
            System.out.println("Total time taken: " + Duration.between(startTime,endTime).getSeconds() + "s");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
