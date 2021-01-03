package com.skillsoft.concurrency.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class WebPageDonwloaderMultiThreaded implements Runnable {

    private String[] urlsList;

    public WebPageDonwloaderMultiThreaded(String[] urlsList) {
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
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void downloadPages() {
        String[] urls = new String[]{"https://www.skillsoft.com/blog",
                "https://www.skillsoft.com/partners",
                "https://www.skillsoft.com/about",
                "https://www.skillsoft.com/resources",
                "https://www.skillsoft.com/about/awards",
                "https://www.skillsoft.com/leadership-team",
                "https://www.skillsoft.com/elearning-events",
                "https://www.skillsoft.com/about/culture",
                "https://www.skillsoft.com/about/global-career-opportunities",
                "https://www.skillsoft.com/case-studies",
                "https://www.skillsoft.com/news",
                "https://www.skillsoft.com/case-studies?industry=sports"};

        Thread downloaderOne = new Thread(new WebPageDonwloaderMultiThreaded(Arrays.copyOfRange(urls, 0, 6)));
        Thread downloaderTwo = new Thread(new WebPageDonwloaderMultiThreaded(Arrays.copyOfRange(urls, 6, urls.length)));

        try {
            Instant startTime = Instant.now();
            downloaderOne.start();
            downloaderTwo.start();

            downloaderOne.join();
            downloaderTwo.start();
            Instant endTime = Instant.now();
            System.out.println("Total time taken: " + Duration.between(startTime,endTime).getSeconds() + "s");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
