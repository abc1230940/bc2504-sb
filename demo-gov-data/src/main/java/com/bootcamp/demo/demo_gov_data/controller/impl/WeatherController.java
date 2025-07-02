package com.bootcamp.demo.demo_gov_data.controller.impl;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_gov_data.controller.WeatherOperation;
import com.bootcamp.demo.demo_gov_data.entity.WeatherEntity;
import com.bootcamp.demo.demo_gov_data.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_gov_data.service.WeatherService;

@RestController
public class WeatherController implements WeatherOperation { 
  @Autowired
  private WeatherService weatherService;

  @Override
  public WeatherDTO getNineDayWeathers() {
    return this.weatherService.getNineDayWeather();
    
  }

  @Override
  public WeatherEntity getWeatherByDate(LocalDate date) {
    WeatherEntity weatherEntity = this.weatherService.getWeatherByDate(date).orElse(null);
    return weatherEntity;
  }
}
