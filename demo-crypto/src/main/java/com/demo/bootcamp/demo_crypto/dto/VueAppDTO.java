package com.demo.bootcamp.demo_crypto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class VueAppDTO {
  private String id;
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
