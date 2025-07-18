package com.example.bootcamp.stock_market_data_provider.service;

import com.example.bootcamp.stock_market_data_provider.model.dto.StockDataDTO;

public interface StockDataService {

  StockDataDTO getStockData(String symbol);
}
