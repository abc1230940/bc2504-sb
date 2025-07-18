package com.example.bootcamp.stock_market_project.model.mapper;

import org.springframework.stereotype.Component;
import com.example.bootcamp.stock_market_project.entity.OhlcDataEntity;
import com.example.bootcamp.stock_market_project.model.OhlcData;
import com.example.bootcamp.stock_market_project.redis.dto.RedisOhlcDataDTO;

@Component
public class ModelMapper {

  public OhlcData map(RedisOhlcDataDTO redisOhlcDataDTO) {
    return OhlcData.builder().code(redisOhlcDataDTO.getCode())
        .date(redisOhlcDataDTO.getDate()).open(redisOhlcDataDTO.getOpen())
        .high(redisOhlcDataDTO.getHigh()).low(redisOhlcDataDTO.getLow())
        .close(redisOhlcDataDTO.getClose()).volume(redisOhlcDataDTO.getVolume())
        .build();
  }

  public OhlcData map(OhlcDataEntity ohlcDataEntity) {
    return OhlcData.builder().code(ohlcDataEntity.getCode())
        .date(ohlcDataEntity.getDate()).open(ohlcDataEntity.getOpen())
        .high(ohlcDataEntity.getHigh()).low(ohlcDataEntity.getLow())
        .close(ohlcDataEntity.getClose()).volume(ohlcDataEntity.getVolume())
        .build();
  }
}
