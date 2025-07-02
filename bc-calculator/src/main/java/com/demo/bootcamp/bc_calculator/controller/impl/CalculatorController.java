package com.demo.bootcamp.bc_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bootcamp.bc_calculator.controller.CalculatorOperator;
import com.demo.bootcamp.bc_calculator.dto.RequestDTO;
import com.demo.bootcamp.bc_calculator.dto.ResponseDTO;
import com.demo.bootcamp.bc_calculator.model.Operation;
import com.demo.bootcamp.bc_calculator.service.CalculatorService;

@RestController
public class CalculatorController implements CalculatorOperator {
  @Autowired
  private CalculatorService calculatorService;

  @Override
  public ResponseDTO operate1(String x, String y, String operation) {
    return operate(x, y, operation);
  }

  @Override
  public ResponseDTO operate2(String x, String y, String operation) {
    return operate(x, y, operation);
  }

  @Override
  public ResponseDTO operate3(RequestDTO requestDTO) {
    return operate(requestDTO.getX(), requestDTO.getY(), requestDTO.getOperation());
  }
    

    // ! Happy Flow only -> unhappy的會自動彈走

  // 1. NumberFormatException (Type)
    // 2. null check
    // 3. Conversion (enum)
    // 4. Exception Handling

  private ResponseDTO operate(String x, String y, String operation) {
    if (x == null || y == null || operation == null)
      throw new IllegalArgumentException("Invalid Operation.");
    double doubleX = Double.parseDouble(x); //將String轉做double primitive
    double doubleY = Double.parseDouble(y);
    Operation op = Operation.of(operation); // 能夠將String轉返去enum中的其中一個文字的方法，佢本身應該會有valueOf呢個方法
    double result = this.calculatorService.operate(doubleX, doubleY, op);
    return ResponseDTO.builder() //
        .x(x) //
        .y(y) //
        .operation(operation) //
        .result(String.valueOf(result)) //
        .build();
  }
}
