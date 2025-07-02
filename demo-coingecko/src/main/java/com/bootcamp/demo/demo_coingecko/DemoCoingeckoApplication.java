package com.bootcamp.demo.demo_coingecko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoCoingeckoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCoingeckoApplication.class, args);
	}

}
