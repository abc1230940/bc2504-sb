package com.bootcamp.demo.bc_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder

public class Calculator {
  private String x;
  private String y;
  private Operation operation;
  private String result;

}

