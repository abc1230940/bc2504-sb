package com.bootcamp.demo.demo_coingecko.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_coingecko.dto.VueAppDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinOperation {
  
  @CrossOrigin
  @GetMapping(value = "/coindata")
  List<VueAppDTO> getCoinData(@RequestParam String currency, @RequestParam String coin) throws JsonProcessingException;
  
}
