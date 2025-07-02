package com.bootcamp.demo.demo_coin_app.service;

import java.util.List;
import com.bootcamp.demo.demo_coin_app.model.dto.CoinData;

public interface MainPageService {
  
  List<CoinData> fetchCoinData();

}
