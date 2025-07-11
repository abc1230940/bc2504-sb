package com.example.bootcamp.stock_market_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bootcamp.stock_market_project.repository.StockRepository;
import com.example.bootcamp.stock_market_project.service.StockService;

@Service
public class StockServiceImpl implements StockService {
  @Autowired
  private StockRepository stockRepository;
}
