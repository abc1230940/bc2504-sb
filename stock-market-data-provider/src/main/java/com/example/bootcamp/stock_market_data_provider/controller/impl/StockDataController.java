package com.example.bootcamp.stock_market_data_provider.controller.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.bootcamp.stock_market_data_provider.controller.StockDataOperation;
import com.example.bootcamp.stock_market_data_provider.dto.StockDataRespDTO;
import com.example.bootcamp.stock_market_data_provider.dto.mapper.DTOMapper;
import com.example.bootcamp.stock_market_data_provider.model.dto.StockDataDTO;
import com.example.bootcamp.stock_market_data_provider.service.StockDataService;

@RestController
public class StockDataController implements StockDataOperation {
  @Autowired
  private StockDataService stockDataService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<StockDataRespDTO> getAllStockData() {

    List<StockDataRespDTO> stockDataRespDTOs = new ArrayList<>();

    List<String> symbols = Arrays.asList("AAPL", // Apple Inc.
        "MSFT", // Microsoft Corporation
        "GOOGL", // Alphabet Inc.
        "AMZN", // Amazon.com Inc.
        "TSLA", // Tesla Inc.
        "NVDA", // NVIDIA Corporation
        "JPM", // JPMorgan Chase & Co.
        "V", // Visa Inc.
        "WMT", // Walmart Inc.
        "JNJ", // Johnson & Johnson
        "PG", // Procter & Gamble Co.
        "DIS", // The Walt Disney Company
        "NFLX", // Netflix Inc.
        "XOM", // Exxon Mobil Corporation
        "BAC");

    for (String s : symbols) {
      StockDataDTO stockDataDTO = this.stockDataService.getStockData(s);
      stockDataRespDTOs.add(this.dtoMapper.map(stockDataDTO, s));
    }

    return stockDataRespDTOs;

  }
}
