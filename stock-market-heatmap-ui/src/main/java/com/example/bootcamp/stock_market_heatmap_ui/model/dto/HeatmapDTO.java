package com.example.bootcamp.stock_market_heatmap_ui.model.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class HeatmapDTO {
  private String symbol;
  private Double currentPrice;
  private Double change;
  private Double percentChange;
  private Double highPriceOfTheDay;
  private Double lowPriceOfTheDay;
  private Double openPriceOfTheDay;
  private Double previousClosePrice;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime timestamp;
}
