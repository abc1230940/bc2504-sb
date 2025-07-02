package com.bootcamp.demo.demo_coingecko.entity;

import java.io.Serializable;
import org.springframework.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coins")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class CoinEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NonNull
  private String coinId;
  private String symbol;
  @Column(length = 100)
  private String name;
  private String image;
  @Column(name = "price")
  private Double currentPrice;
  @Column(name = "market_cap")
  private Double marketCap;
  @Column(name = "market_cap_rank")
  private Integer marketCapRank;
  @Column(name = "price_change_24h")
  private Double priceChange24h;
  @Column(name = "price_change_percentage_24h", columnDefinition = "DECIMAL(10,2)")
  private Double priceChangePercentage24h;
  @Column(name = "total_volume")
  private Long totalVolume;
}
