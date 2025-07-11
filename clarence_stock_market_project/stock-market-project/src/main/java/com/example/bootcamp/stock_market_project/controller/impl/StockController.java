package com.example.bootcamp.stock_market_project.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.bootcamp.stock_market_project.controller.StockOperation;
import com.example.bootcamp.stock_market_project.service.StockService;

@RestController
public class StockController implements StockOperation {
  @Autowired
  private StockService stockService;
}
