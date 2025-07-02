package com.bootcamp.demo.demo_gov_data.controller;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.demo_gov_data.entity.WeatherEntity;
import com.bootcamp.demo.demo_gov_data.model.dto.WeatherDTO;

public interface WeatherOperation {

  @GetMapping(value = "/9dayweathers")
  @ResponseStatus(value = HttpStatus.OK)
  WeatherDTO getNineDayWeathers();

  @GetMapping(value = "date/{date}/weather")
  @ResponseStatus(value = HttpStatus.OK)
  WeatherEntity getWeatherByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
