package com.example.bootcamp.stock_market_project.redis.mapper;

import org.springframework.stereotype.Component;
import com.example.bootcamp.stock_market_project.entity.OhlcDataEntity;
import com.example.bootcamp.stock_market_project.redis.dto.RedisOhlcDataDTO;

@Component
public class RedisMapper {

  public RedisOhlcDataDTO map(OhlcDataEntity ohlcDataEntity) {
    return RedisOhlcDataDTO.builder().code(ohlcDataEntity.getCode())
        .date(ohlcDataEntity.getDate()).open(ohlcDataEntity.getOpen())
        .high(ohlcDataEntity.getHigh()).low(ohlcDataEntity.getLow())
        .close(ohlcDataEntity.getClose()).volume(ohlcDataEntity.getVolume())
        .build();
  }
}
