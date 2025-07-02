package com.bootcamp.demo.demo_coin_app.model.dto;

import java.time.LocalDateTime;
import com.bootcamp.demo.demo_coin_app.lib.CustomTimestampDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class CoinData {
  private String id;
  private String name;
  private String image;
  @JsonProperty("current_price")
  private Double currentPrice;
  @JsonProperty("market_cap")
  private Long marketCap;
  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercent24h;
  @JsonProperty("last_updated")
  @JsonDeserialize(using = CustomTimestampDeserializer.class)
  private LocalDateTime lastUpdated;
}
