package com.bootcamp.demo.demo_coingecko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder

public class Coin {
  private String coinId;
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Double marketCap;
  private Integer marketCapRank;
  private Double priceChange24h;
  private Double priceChangePercentage24h;
  private Long totalVolume;
}
