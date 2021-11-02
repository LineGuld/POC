package com.example.POC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class PocApplication {

	public static void main(String... args) {
		SpringApplication.run(PocApplication.class, args);
	}
}
