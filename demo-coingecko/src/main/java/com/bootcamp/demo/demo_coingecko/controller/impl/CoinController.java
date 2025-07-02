package com.bootcamp.demo.demo_coingecko.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_coingecko.controller.CoinOperation;
import com.bootcamp.demo.demo_coingecko.dto.CoinDTO;
import com.bootcamp.demo.demo_coingecko.dto.VueAppDTO;
import com.bootcamp.demo.demo_coingecko.dto.mapper.DTOMapper;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CoinController implements CoinOperation {
  @Autowired
  private CoinService coinService;
  @Autowired
  private DTOMapper dtoMapper;
  
  @Override
  public List<VueAppDTO> getCoinData(String currency, String coin) throws JsonProcessingException {
    String[] coins = coin.split(",");
    List<Coin> coinsList = this.coinService.getMarketWithCache(currency, List.of(coins));
    List<CoinDTO> coinDTOs = coinsList.stream().map(c -> this.dtoMapper.map(c)).collect(Collectors.toList());
    return coinDTOs.stream().map(c -> this.dtoMapper.map(c)).collect(Collectors.toList());
  }
}
