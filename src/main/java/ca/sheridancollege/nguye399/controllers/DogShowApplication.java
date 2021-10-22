package ca.sheridancollege.nguye399.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "ca.sheridancollege.nguye399.dogs", "ca.sheridancollege.nguye399.controllers",
		"ca.sheridancollege.nguye399.database" })
public class DogShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogShowApplication.class, args);
	}

}
