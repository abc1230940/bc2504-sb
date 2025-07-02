package com.demo.bootcamp.bc_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class RequestDTO {
  private String x;
  private String y;
  private String operation;
}
