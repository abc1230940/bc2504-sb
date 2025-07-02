package com.bootcamp.demo.demo_coingecko.redis.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.redis.dto.RedisCoinDTO;

@Component
public class RedisMapper {
  public RedisCoinDTO map(CoinEntity coinEntity) {
    return RedisCoinDTO.builder().coinId(coinEntity.getCoinId())
        .symbol(coinEntity.getSymbol()) //
        .name(coinEntity.getName()) //
        .image(coinEntity.getImage()) //
        .currentPrice(coinEntity.getCurrentPrice()) //
        .marketCap(coinEntity.getMarketCap())
        .marketCapRank(coinEntity.getMarketCapRank())
        .priceChange24h(coinEntity.getPriceChange24h()) //
        .priceChangePercentage24h(coinEntity.getPriceChangePercentage24h()) //
        .totalVolume(coinEntity.getTotalVolume())
        .build();
  }
}
