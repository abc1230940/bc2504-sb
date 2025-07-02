package com.bootcamp.demo.demo_coingecko.model.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor


// ! 戰略 -> 將佢的_轉返做JAVA命名方法，但不能用在數字上
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MarketDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Double marketCap;
  private Integer marketCapRank;
  private Long fullyDilutedValuation;
  private Long totalVolume;
  @JsonProperty("high_24h")
  private Double high24h;
  @JsonProperty("low_24h")
  private Double low24h;
  @JsonProperty("price_change_24h")
  private Double priceChange24h;
  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercentage24h;
  @JsonProperty("market_cap_change_24h")
  private Double marketCapChange24h;
  @JsonProperty("market_cap_change_percentage_24h")
  private Double marketCapChangePercentage24h;
  private Double circulatingSupply;
  private Double totalSupply;
  private Double maxSupply;
  private Double ath;
  private Double athChangePercentage;
  private LocalDateTime athDate;
  private Long atl;
  private Long atlChangePercentage;
  private LocalDateTime atlDate;
  private ROI roi;
  private LocalDateTime lastUpdated;

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @Getter
    public static class ROI {
        private Double times;
        private String currency;
        private Double percentage;

    }
}
