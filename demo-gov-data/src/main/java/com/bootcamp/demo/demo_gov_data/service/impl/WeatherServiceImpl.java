package com.bootcamp.demo.demo_gov_data.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_gov_data.entity.WeatherEntity;
import com.bootcamp.demo.demo_gov_data.entity.mapper.EntityMapper;
import com.bootcamp.demo.demo_gov_data.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_gov_data.repository.WeatherRepository;
import com.bootcamp.demo.demo_gov_data.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
  @Value("${service-url.weathers}")
  private String url;
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private WeatherRepository weatherRepository;
  @Autowired
  private EntityMapper entityMapper;

  @Override
  public WeatherDTO getNineDayWeather() {
    WeatherDTO dtos =
        this.restTemplate.getForObject(this.url, WeatherDTO.class);
    return dtos;
  }

  @Override
  // 直接將external API的東西轉為entity
  // 要知道從咩換成咩
  public List<WeatherEntity> loadNineDayWeather() {
    List<WeatherEntity> weatherEntities =
        this.getNineDayWeather().getForecasts().stream()
            .map(forecast -> this.entityMapper.map(forecast))
            .collect(Collectors.toList());
    return this.weatherRepository.saveAll(weatherEntities);
  }

  @Override
  public Optional<WeatherEntity> getWeatherByDate(LocalDate date) {
    return this.weatherRepository.getWeatherJPQL(date);
  }

  @Override
  public List<WeatherEntity> getAllWeatherEntities() {
    return this.weatherRepository.findAll();
  }
}
