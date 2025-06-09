package com.bootcamp.demo.bc_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ResponseDTO {
  private String result;
  private String x;
  private String y;
  private String operation;
}
