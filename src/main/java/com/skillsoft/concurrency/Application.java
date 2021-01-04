package com.skillsoft.concurrency;

import com.skillsoft.concurrency.service.threadmethods.IsAliveThreadDemo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

	public static void main(String[] args) throws InterruptedException {
		log.info("Starting Application...");
		new IsAliveThreadDemo().isAliveDemo();
	}

}
