package com.bootcamp.demo.demo_sb_restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// ! Spring Context
// Server Start (in-progress) -> prepare Spring context
// 1. check any class with @Controller, @Service, @Repository, @Configuration, @Component
	// 1a. CatController -> @Autowired CatService (CatController bean depends on CatService Bean)
// 2. create an object (bean) for the above classes, put the beans into context
	// ! 2a. Create CatService bean first, then create CatController bean

@SpringBootApplication
public class DemoSbRestfulApplication {
	// ! After server starts, we got the spring context memory location
	public static ConfigurableApplicationContext context; // 地址

	public static void main(String[] args) {
		context = SpringApplication.run(DemoSbRestfulApplication.class, args); // 7x24
	}

}
