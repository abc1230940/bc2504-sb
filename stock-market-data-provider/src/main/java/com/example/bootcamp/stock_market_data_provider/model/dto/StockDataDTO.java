package com.example.bootcamp.stock_market_data_provider.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class StockDataDTO {
  @JsonProperty(value = "c")
  private Double currentPrice;
  @JsonProperty(value = "d")
  private Double change;
  @JsonProperty(value = "dp")
  private Double percentChange;
  @JsonProperty(value = "h")
  private Double highPriceOfTheDay;
  @JsonProperty(value = "l")
  private Double lowPriceOfTheDay;
  @JsonProperty(value = "o")
  private Double openPriceOfTheDay;
  @JsonProperty(value = "pc")
  private Double previousClosePrice;
  @JsonProperty(value = "t")
  private Long timestamp;

}
