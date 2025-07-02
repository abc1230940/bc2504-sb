package com.demo.bootcamp.demo_crypto.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bootcamp.demo_crypto.controller.CryptoOperation;
import com.demo.bootcamp.demo_crypto.dto.VueAppDTO;
import com.demo.bootcamp.demo_crypto.dto.mapper.dtoMapper;
import com.demo.bootcamp.demo_crypto.model.dto.CoinDTO;
import com.demo.bootcamp.demo_crypto.service.CryptoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CryptoController implements CryptoOperation {
  @Autowired
  private CryptoService cryptoService;
  @Autowired
  private dtoMapper dtoMapper;
  

  @Override
  public List<VueAppDTO> getCoinData(String currency, List<String> coins) throws JsonProcessingException {
    List<CoinDTO> coinDTOs =  this.cryptoService.getCoinfromGecko(currency, coins);
    return coinDTOs.stream().map(coinDTO -> this.dtoMapper.map(coinDTO)).collect(Collectors.toList());
  }
}
