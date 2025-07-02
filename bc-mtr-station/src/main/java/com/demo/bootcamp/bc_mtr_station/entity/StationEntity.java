package com.demo.bootcamp.bc_mtr_station.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class StationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Nonnull // ! safeguard the java level -> 你可以夾硬去DB到改
  private String stationCode;
  @Column(name = "station_name")
  @Nonnull
  private String name;
  private String prev;
  private String next;

  @ManyToOne
  @JoinColumn(name = "line_id")
  @Nonnull
  private LineEntity lineEntity;
}
