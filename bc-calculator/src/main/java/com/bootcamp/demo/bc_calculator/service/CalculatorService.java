package com.bootcamp.demo.bc_calculator.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_calculator.model.Operation;

// ! 在Service全部都係寫最底層的計算，已經convert晒, 唔會再驗證任何東西，controller做晒所有conversion and exception
@Service
public interface CalculatorService {
  
   double operate(double x, double y, Operation operation);
}
