package com.demo.bootcamp.bc_calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.demo.bootcamp.bc_calculator.model.Operation;
import com.demo.bootcamp.bc_calculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {
  @Override
  public double operate(double x, double y, Operation operation) {
    // switch expression -> enum
    if (operation == null)
      throw new RuntimeException("Invalid operation.");

    double result = switch (operation) {
      case ADD -> add(x, y);
      case SUB -> subtract(x, y);
      case MUL -> multiply(x, y);
      case DIV -> divide(x, y);
    };
    return result;
  }

  // BigDecimal -> double operation
  private double add(double x, double y) {
    return BigDecimal.valueOf(x).add(BigDecimal.valueOf(y)).doubleValue();
  }

  private double subtract(double x, double y) {
    return BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y)).doubleValue();
  }

  private double multiply(double x, double y) {
    return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).doubleValue();
  }

  // TODO: divide zero, rounding, etc..
  private double divide(double x, double y) {
    return BigDecimal.valueOf(x) //
        .divide(BigDecimal.valueOf(y), 5, RoundingMode.HALF_UP) //
        .doubleValue();
  }
}
