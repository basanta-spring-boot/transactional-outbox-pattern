package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrderPollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderPollerApplication.class, args);
	}

}
