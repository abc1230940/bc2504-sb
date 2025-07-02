package com.bootcamp.demo.demo_gov_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoGovDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGovDataApplication.class, args);
	}

}
