package com.learning_springboot.learning_springboot;

import com.learning_springboot.learning_springboot.run.Location;
import com.learning_springboot.learning_springboot.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class LearningSpringbootApplication {
	private static final Logger log = LoggerFactory.getLogger(LearningSpringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringbootApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
            log.info("Run: {}", run);
		};
	}
}