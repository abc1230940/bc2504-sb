package com.example.bootcamp.stock_market_project.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.bootcamp.stock_market_project.controller.StockOperation;
import com.example.bootcamp.stock_market_project.dto.AllStockDataRespDTO;
import com.example.bootcamp.stock_market_project.dto.OhlcDataRespDTO;
import com.example.bootcamp.stock_market_project.dto.mapper.DTOMapper;
import com.example.bootcamp.stock_market_project.model.OhlcData;
import com.example.bootcamp.stock_market_project.model.dto.StockDTO;
import com.example.bootcamp.stock_market_project.service.OhlcService;
import com.example.bootcamp.stock_market_project.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class StockController implements StockOperation {
  @Autowired
  private StockService stockService;
  @Autowired
  private OhlcService ohlcService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<AllStockDataRespDTO> getAllStockData() {
    List<StockDTO> stockDTOs = this.stockService.getAllStockData();
    return stockDTOs.stream().map(s -> this.dtoMapper.map(s))
        .collect(Collectors.toList());
  }

  @Override
  public List<OhlcDataRespDTO> getOhlcDataByCode(@RequestParam String code)
      throws JsonProcessingException {
    List<OhlcData> ohlcData = this.ohlcService.getOhlcDataWithCache(code);
    return ohlcData.stream().map(d -> this.dtoMapper.map(d))
        .collect(Collectors.toList());
  }
}
