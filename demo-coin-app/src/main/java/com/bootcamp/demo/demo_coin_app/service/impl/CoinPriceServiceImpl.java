package com.bootcamp.demo.demo_coin_app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_coin_app.entity.CoinPriceEntity;
import com.bootcamp.demo.demo_coin_app.entity.mapper.EntityMapper;
import com.bootcamp.demo.demo_coin_app.model.dto.CoinData;
import com.bootcamp.demo.demo_coin_app.repository.CoinPriceRepository;
import com.bootcamp.demo.demo_coin_app.service.CoinPriceService;

@Service
public class CoinPriceServiceImpl implements CoinPriceService{
  @Autowired
  private CoinPriceRepository coinPriceRepository;
  @Autowired
  private EntityMapper entityMapper;
  
  @Override
  public List<CoinPriceEntity> create(List<CoinData> coinDatas) {
    List<CoinPriceEntity> coinPriceEntities = coinDatas.stream() //
        .map(e -> {
          CoinPriceEntity coinPriceEntity = this.entityMapper.map(e);
          coinPriceEntity.setSubmitDatetime(LocalDateTime.now());
          return coinPriceEntity;
        })
        .collect(Collectors.toList());
    return this.coinPriceRepository.saveAll(coinPriceEntities);
  }
}
