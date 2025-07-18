package com.example.bootcamp.stock_market_project.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class OhlcData {

  private String code;
  private LocalDate date;
  private Double open;
  private Double high;
  private Double low;
  private Double close;
  private Long volume;
}
