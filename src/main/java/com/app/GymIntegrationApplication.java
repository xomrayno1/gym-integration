package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
@EnableJpaRepositories
public class GymIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymIntegrationApplication.class, args);
	}
 
}
