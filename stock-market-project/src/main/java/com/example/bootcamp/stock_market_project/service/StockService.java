package com.example.bootcamp.stock_market_project.service;

import java.util.List;
import com.example.bootcamp.stock_market_project.model.dto.StockDTO;

public interface StockService {

  List<StockDTO> getAllStockData();
}
