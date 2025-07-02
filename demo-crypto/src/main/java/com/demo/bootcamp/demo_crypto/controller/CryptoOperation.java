package com.demo.bootcamp.demo_crypto.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.bootcamp.demo_crypto.dto.VueAppDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CryptoOperation {
  @GetMapping(value = "/coindata")
  List<VueAppDTO> getCoinData(@RequestParam String currency, @RequestParam List<String> coins) throws JsonProcessingException;
}
