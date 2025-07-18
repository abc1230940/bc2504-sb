package com.example.bootcamp.stock_market_project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.bootcamp.stock_market_project.dto.AllStockDataRespDTO;
import com.example.bootcamp.stock_market_project.dto.OhlcDataRespDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockOperation {

  @GetMapping(value = "/stockdata")
  List<AllStockDataRespDTO> getAllStockData();

  @GetMapping(value = "/ohlcdata")
  List<OhlcDataRespDTO> getOhlcDataByCode(@RequestParam String code)
      throws JsonProcessingException;
}
