package com.bootcamp.demo.demo_coingecko.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RedisCoinDTO {
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

