package com.vodafone.reward.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication : This annotation tells spring boot that this class is
 *                        a starting point.
 * @author pkadake
 *
 */
@SpringBootApplication(scanBasePackages = "com.vodafone.*")
public class RewardSystemApplication {

	/**
	 * SpringApplication.run() is Static helper method which will bootstrap and
	 * launch a Spring application from a Java main method. Bootstrap include:
	 * 1) Sets up default configuration 2) Starts Spring application context 3)
	 * Performs class path scan for spring annotations 4) Starts Tomcat Server
	 */
	public static void main(String[] args) {
		SpringApplication.run(RewardSystemApplication.class, args);
	}
}
