package com.demo.bootcamp.demo_crypto.service;

import java.util.List;
import com.demo.bootcamp.demo_crypto.model.dto.CoinDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CryptoService {
  
  List<CoinDTO> getCoinfromGecko(String currency, List<String> targetCoins) throws JsonProcessingException;
}
