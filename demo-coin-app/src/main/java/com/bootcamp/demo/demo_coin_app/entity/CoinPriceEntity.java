package com.bootcamp.demo.demo_coin_app.entity;

import java.time.LocalDateTime;
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
import lombok.Setter;

@Entity
@Table(name = "coinlist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class CoinPriceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String coinId;
  @Column(name = "coin_name")
  private String name;
  private Double currentPrice;
  @Setter
  @Column(name = "submit_datatime")
  private LocalDateTime submitDatetime;
}
