package com.bootcamp.demo.demo_coin_app.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coin_app.entity.CoinPriceEntity;
import com.bootcamp.demo.demo_coin_app.model.dto.CoinData;

@Component
public class EntityMapper {

  public CoinPriceEntity map(CoinData coinData) {
    return CoinPriceEntity.builder().coinId(coinData.getId())
        .name(coinData.getName()).currentPrice(coinData.getCurrentPrice())
        .build();
  }
}
