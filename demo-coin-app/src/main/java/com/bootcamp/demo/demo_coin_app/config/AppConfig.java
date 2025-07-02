package com.bootcamp.demo.demo_coin_app.config;

import java.time.LocalDateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_coin_app.lib.CustomTimestampDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    // Normal LocalDataTime module
    mapper.registerModule(new JavaTimeModule());
    // Custom Deserializer module
    SimpleModule utcToHktModule = new SimpleModule();
    utcToHktModule.addDeserializer(LocalDateTime.class,
        new CustomTimestampDeserializer());
    mapper.registerModule(utcToHktModule);
    return mapper;
  }
}
