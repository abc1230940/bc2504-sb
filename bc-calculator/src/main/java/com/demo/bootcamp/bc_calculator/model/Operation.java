package com.demo.bootcamp.bc_calculator.model;

public enum Operation {
  ADD, SUB, MUL, DIV,;


  // !! enum與輸入很重要的方法
  public static Operation of(String operation) {
    for (Operation op : Operation.values()) {
      if (op.name().equalsIgnoreCase(operation))
        return op;
    }
    throw new RuntimeException("Operation is invalid.");
  }
}
