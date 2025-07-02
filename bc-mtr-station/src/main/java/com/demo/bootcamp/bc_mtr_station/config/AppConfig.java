package com.demo.bootcamp.bc_mtr_station.config;

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
