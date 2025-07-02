package com.bootcamp.demo.demo_coin_app.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_coin_app.model.dto.CoinData;
import com.bootcamp.demo.demo_coin_app.service.MainPageService;

@Service
public class MainPageServiceImpl implements MainPageService{
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinData> fetchCoinData() {
    String url = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    CoinData[] response = restTemplate.getForObject(url, CoinData[].class);
        return Arrays.asList(response);
  }

  
}
