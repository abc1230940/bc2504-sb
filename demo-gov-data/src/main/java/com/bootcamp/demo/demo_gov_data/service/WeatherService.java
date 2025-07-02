package com.bootcamp.demo.demo_gov_data.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_gov_data.entity.WeatherEntity;
import com.bootcamp.demo.demo_gov_data.model.dto.WeatherDTO;

public interface WeatherService {
  
  WeatherDTO getNineDayWeather();
  List<WeatherEntity> loadNineDayWeather();
  List<WeatherEntity> getAllWeatherEntities();
  Optional<WeatherEntity> getWeatherByDate(LocalDate date);
}
