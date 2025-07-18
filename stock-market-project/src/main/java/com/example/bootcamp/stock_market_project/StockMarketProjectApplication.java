package com.example.bootcamp.stock_market_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockMarketProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketProjectApplication.class, args);
	}

}
