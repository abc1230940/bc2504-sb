package com.demo.bootcamp.demo_crypto.dto.mapper;

import org.springframework.stereotype.Component;
import com.demo.bootcamp.demo_crypto.dto.VueAppDTO;
import com.demo.bootcamp.demo_crypto.model.dto.CoinDTO;

@Component
public class dtoMapper {

  public VueAppDTO map(CoinDTO coinDTO) {
    return VueAppDTO.builder().id(coinDTO.getId()).symbol(coinDTO.getSymbol())
        .name(coinDTO.getName()).image(coinDTO.getImage())
        .currentPrice(coinDTO.getCurrentPrice())
        .marketCap(coinDTO.getMarketCap())
        .marketCapRank(coinDTO.getMarketCapRank())
        .priceChange24h(coinDTO.getPriceChange24h())
        .priceChangePercentage24h(coinDTO.getPriceChangePercentage24h())
        .totalVolume(coinDTO.getTotalVolume()).build();
  }
}
