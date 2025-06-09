package com.bootcamp.demo.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_calculator.dto.RequestDTO;
import com.bootcamp.demo.bc_calculator.dto.ResponseDTO;

public interface CalculatorOperation {

  @GetMapping(value = "/operation")
  ResponseDTO operate1(@RequestParam String x, @RequestParam String y, @RequestParam String operation);

  @GetMapping(value = "/operation/{x}{y}/{operation}")
  ResponseDTO operate2(@PathVariable String x, @PathVariable String y, @PathVariable String operation);

  @PostMapping(value = "/operation")
  ResponseDTO operate3(@RequestBody RequestDTO requestDTO);
}
