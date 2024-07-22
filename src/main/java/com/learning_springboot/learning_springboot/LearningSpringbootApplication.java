package com.learning_springboot.learning_springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearningSpringbootApplication {
	private static final Logger log = LoggerFactory.getLogger(LearningSpringbootApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearningSpringbootApplication.class, args);

		// Instead of creating a WelcomeMessage instance with instantiation in a java way,
		// You can create an instance by accessing the bean from the application context
		// WelcomeMessage welcomeMessage = new WelcomeMessage();    // java way
		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
		System.out.println(welcomeMessage.getWelcomeMessage());

		// Logging levels (debug, warn, error, trace, etc)
		log.info("Application started successfully");
	}

}
