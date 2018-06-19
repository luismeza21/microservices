package com.sportime.sportime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SportimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportimeApplication.class, args);
	}
}
