package com.bootcamp.demo.demo_gov_data.model.dto;

import java.time.OffsetDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

// https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en
// ! Spring Boot -> 1. 自動轉Long 2. 自動轉static class

@AllArgsConstructor
@Getter

public class WeatherDTO {
  private String generalSituation;
  @JsonProperty(value = "weatherForecast")
  private List<Forecast> forecasts;
  private OffsetDateTime updateTime;  // ! API是STRING, 要轉換為時間 // deserialization String同Long都可以用到
  private SeaTemp seaTemp;
  private List<SoilTemp> soilTemp;

  @AllArgsConstructor
  @Getter

  public static class SeaTemp {
    private String place;
    private Long value; // ! 防止小數同null -> Open API要睇清楚requirement -> double放入long不行
    private String unit;
    private OffsetDateTime recordTime;

  }

  @AllArgsConstructor
  @Getter

  public static class SoilTemp {
    private String place;
    private Long value;
    private String unit;
    private OffsetDateTime recordTime;
    private Depth depth;

    @AllArgsConstructor
    @Getter

    public static class Depth {
      private String unit;
      private Double value;
    }
  }


  @AllArgsConstructor
  @Getter

  public static class Forecast {
    @JsonProperty(value = "forecastDate")
    private String Date;
    private String week;
    @JsonProperty(value = "forecastWind")
    private String Wind;
    @JsonProperty(value = "forecastWeather")
    private String Weather;
    @JsonProperty(value = "ForecastIcon")
    private Long icon;
    @JsonProperty(value = "PSR")
    private String psr;
    

    @JsonProperty(value = "forecastMaxtemp")
    private Temperature maxTemp;
    @JsonProperty(value = "forecastMintemp")
    private Temperature minTemp;
    @JsonProperty(value = "forecastMaxrh")
    private Temperature maxHum;
    @JsonProperty(value = "forecastMinrh")
    private Temperature minHum;

    @AllArgsConstructor
    @Getter

    public static class Temperature {
      private Long value;
      private String unit;
    }
  }
}
