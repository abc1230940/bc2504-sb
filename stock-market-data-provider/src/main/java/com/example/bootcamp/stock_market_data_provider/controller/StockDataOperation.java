package com.example.bootcamp.stock_market_data_provider.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bootcamp.stock_market_data_provider.dto.StockDataRespDTO;

public interface StockDataOperation {
  @GetMapping(value = "/stock")
  List<StockDataRespDTO> getAllStockData();
}
