package com.demo.bootcamp.bc_forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Java Built-in Class

@Configuration
public class AppConfig {
  @Bean // created at Spring Context after server starts
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
}
