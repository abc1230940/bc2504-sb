package com.demo.bootcamp.bc_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class ErrorDTO {
  private Integer code;
  private String message;

}
