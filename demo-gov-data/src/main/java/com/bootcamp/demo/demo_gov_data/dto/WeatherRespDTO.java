package com.bootcamp.demo.demo_gov_data.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class WeatherRespDTO {

  private String generalSituation; 

  private List<Forecast> forecasts;
  private LocalDateTime upDateTime;  // API是STRING, 要轉換為時間 // deserialization
  private SeaTemp seaTemp;
  private List<SoilTemp> soilTemp;

  @AllArgsConstructor
  @Getter

  public static class SeaTemp {
    private String place;
    private Long value; // ! 防止小數同null -> Open API要睇清楚requirement -> double放入long不行
    private String unit;
    private LocalDateTime recordTime;

  }

  @AllArgsConstructor
  @Getter

  public static class SoilTemp {
    private String place;
    private Long value;
    private String unit;
    private LocalDateTime recordTime;
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
    private String Date;
    private String week;
    private String Wind;
    private String Weather;
    private Long icon;
    private String psr;
    

    private Temperature maxTemp;
    private Temperature minTemp;
    private Temperature maxHum;
    private Temperature minHum;

    @AllArgsConstructor
    @Getter

    public static class Temperature {
      private Long value;
      private String unit;
    }
  }
}

