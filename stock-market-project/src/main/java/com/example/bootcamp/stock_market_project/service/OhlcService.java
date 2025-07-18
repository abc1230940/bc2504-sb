package com.example.bootcamp.stock_market_project.service;

import java.util.List;
import com.example.bootcamp.stock_market_project.entity.OhlcDataEntity;
import com.example.bootcamp.stock_market_project.model.OhlcData;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OhlcService {

  List<OhlcDataEntity> getOhlcData(String code);

  List<OhlcData> getOhlcDataWithCache(String code)
      throws JsonProcessingException;

  void deleteAll();


}
