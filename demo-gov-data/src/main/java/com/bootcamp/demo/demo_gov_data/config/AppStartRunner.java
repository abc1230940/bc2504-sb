package com.bootcamp.demo.demo_gov_data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_gov_data.service.WeatherService;

@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private WeatherService weatherService;

  @Override
  public void run(String... args) throws Exception {
    if (this.weatherService.getAllWeatherEntities().isEmpty()) {
      this.weatherService.loadNineDayWeather();
    }
    
  }
}
