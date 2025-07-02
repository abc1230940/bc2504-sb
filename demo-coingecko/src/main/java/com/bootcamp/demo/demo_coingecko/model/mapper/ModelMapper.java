package com.bootcamp.demo.demo_coingecko.model.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.redis.dto.RedisCoinDTO;

@Component
public class ModelMapper {
  public Coin map(RedisCoinDTO redisCoinDTO) {
    return Coin.builder().coinId(redisCoinDTO.getCoinId())
        .symbol(redisCoinDTO.getSymbol()) //
        .name(redisCoinDTO.getName()) //
        .image(redisCoinDTO.getImage()) //
        .currentPrice(redisCoinDTO.getCurrentPrice()) //
        .marketCap(redisCoinDTO.getMarketCap())
        .marketCapRank(redisCoinDTO.getMarketCapRank())
        .priceChange24h(redisCoinDTO.getPriceChange24h()) //
        .priceChangePercentage24h(redisCoinDTO.getPriceChangePercentage24h()) //
        .totalVolume(redisCoinDTO.getTotalVolume())
        .build();
  }

  public Coin map(CoinEntity coinEntity) {
    return Coin.builder().coinId(coinEntity.getCoinId())
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
