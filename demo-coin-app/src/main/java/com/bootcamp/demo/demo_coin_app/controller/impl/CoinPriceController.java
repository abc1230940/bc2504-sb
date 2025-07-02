package com.bootcamp.demo.demo_coin_app.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_coin_app.controller.CoinPriceOperator;
import com.bootcamp.demo.demo_coin_app.model.dto.CoinData;
import com.bootcamp.demo.demo_coin_app.service.CoinPriceService;
import com.bootcamp.demo.demo_coin_app.service.MainPageService;

@RestController
public class CoinPriceController implements CoinPriceOperator {
  @Autowired
  private CoinPriceService coinPriceService;
  @Autowired
  private MainPageService mainPageService;


  @Override
  public Boolean submit(List<CoinData> coinDatas) {
    System.out.println("coins=" + coinDatas);
    if (coinDatas == null)
      throw new RuntimeException("Invalid Coin List.");
    return this.coinPriceService.create(coinDatas) != null;
  }

  @Override
  public List<CoinData> getCoinList() {
    return this.mainPageService.fetchCoinData();
  }
}
