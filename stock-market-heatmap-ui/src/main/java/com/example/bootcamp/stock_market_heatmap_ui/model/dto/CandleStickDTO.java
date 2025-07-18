package com.example.bootcamp.stock_market_heatmap_ui.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class CandleStickDTO {
  private String code;
  private LocalDate date;
  private Double open;
  private Double high;
  private Double low;
  private Double close;
  private Long volume;
}
