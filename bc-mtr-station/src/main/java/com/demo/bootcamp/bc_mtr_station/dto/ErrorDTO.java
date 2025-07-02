package com.demo.bootcamp.bc_mtr_station.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class ErrorDTO {
  private String code; // "000001"
  private String message;
}
