package com.bootcamp.demo.demo_mte_caller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  // ! maven(pom.xml) -> External class -> object (bean)
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
