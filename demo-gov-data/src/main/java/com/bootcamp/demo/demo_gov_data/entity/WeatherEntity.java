package com.bootcamp.demo.demo_gov_data.entity;

import java.time.LocalDate;
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
@Table(name = "weathers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class WeatherEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate date;
  @Column(name = "max_temp")
  private Long maxTemp;
  // @Column(name = "max_temp_unit")
  // private String maxTempUnit;
  @Column(name = "min_temp")
  private Long minTemp;
  // @Column(name = "min_temp_unit")
  // private String minTempUnit;
  @Column(name = "max_rh")
  private Long maxRh;
  // @Column(name = "max_rh_unit")
  // private String maxRhUnit;
  @Column(name = "min_rh")
  private Long minRh;
  // @Column(name = "min_rh_unit")
  // private String minRhUnit;

  
  // date, max_temp, min_temp, max_rh, min_rh
}
