package com.bluoh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class BluohApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluohApiApplication.class, args);
	}
}
