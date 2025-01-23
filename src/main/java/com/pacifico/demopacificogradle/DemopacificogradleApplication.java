package com.pacifico.demopacificogradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pacifico.demopacificogradle")
public class DemopacificogradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemopacificogradleApplication.class, args);
	}

}
