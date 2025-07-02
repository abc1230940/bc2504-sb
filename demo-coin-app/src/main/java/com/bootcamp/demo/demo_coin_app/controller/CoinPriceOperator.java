package com.bootcamp.demo.demo_coin_app.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_coin_app.model.dto.CoinData;

public interface CoinPriceOperator {
  
  @PostMapping(value = "/coinpage/coins")
  Boolean submit(@RequestBody List<CoinData> coinDatas);

  @GetMapping(value = "/coinlist")
  List<CoinData> getCoinList();
}
