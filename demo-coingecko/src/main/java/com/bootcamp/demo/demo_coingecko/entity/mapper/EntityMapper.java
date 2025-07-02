package com.bootcamp.demo.demo_coingecko.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;

@Component
public class EntityMapper {

  public CoinEntity map(MarketDTO marketDTO) {
    return CoinEntity.builder().coinId(marketDTO.getId())
        .symbol(marketDTO.getSymbol()) //
        .name(marketDTO.getName()) //
        .image(marketDTO.getImage()) //
        .currentPrice(marketDTO.getCurrentPrice()) //
        .marketCap(marketDTO.getMarketCap())
        .marketCapRank(marketDTO.getMarketCapRank())
        .priceChange24h(marketDTO.getPriceChange24h()) //
        .priceChangePercentage24h(marketDTO.getPriceChangePercentage24h()) //
        .totalVolume(marketDTO.getTotalVolume())
        .build();
  }

  // public CoinEntity map(RedisCoinDTO redisCoinDTO) {
  //   return CoinEntity.builder().coinId(redisCoinDTO.getCoinId())
  //       .symbol(redisCoinDTO.getSymbol()) //
  //       .name(redisCoinDTO.getName()) //
  //       .image(redisCoinDTO.getImage()) //
  //       .currentPrice(redisCoinDTO.getCurrentPrice()) //
  //       .marketCap(redisCoinDTO.getMarketCap())
  //       .priceChange24h(redisCoinDTO.getPriceChange24h()) //
  //       .priceChangePercentage24h(redisCoinDTO.getPriceChangePercentage24h()) //
  //       .build();
  // }
}
