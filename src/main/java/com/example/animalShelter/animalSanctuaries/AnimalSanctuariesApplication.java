package com.example.animalShelter.animalSanctuaries;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimalSanctuariesApplication {

	public static void main(String[] args) {

		SpringApplication.run(AnimalSanctuariesApplication.class, args);
	}

}
