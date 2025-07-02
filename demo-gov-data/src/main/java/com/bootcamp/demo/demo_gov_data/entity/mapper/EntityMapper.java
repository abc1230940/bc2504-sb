package com.bootcamp.demo.demo_gov_data.entity.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_gov_data.entity.WeatherEntity;
import com.bootcamp.demo.demo_gov_data.model.dto.WeatherDTO;

// 1 object -> 1 object
@Component
public class EntityMapper {

  private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

  public WeatherEntity map(WeatherDTO.Forecast forecast) {

    return WeatherEntity.builder().date(LocalDate.parse(forecast.getDate(), dateFormatter))
        .maxTemp(forecast.getMaxTemp().getValue())
        .minTemp(forecast.getMinTemp().getValue())
        .maxRh(forecast.getMaxHum().getValue())
        .minRh(forecast.getMinHum().getValue()).build();
  }
}
