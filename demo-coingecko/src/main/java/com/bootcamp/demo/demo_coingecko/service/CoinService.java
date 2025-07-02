package com.bootcamp.demo.demo_coingecko.service;

import java.util.List;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinService {
  // ! read and write the cache (new)
  List<Coin> getMarketWithCache(String currency, List<String> targetCoins) throws JsonProcessingException;

  // Call coingecko api
  List<MarketDTO> getMarkets(String currency, List<String> coins);
  List<CoinEntity> create(List<CoinEntity> coinEntities);
  void deleteAll();
  
}
