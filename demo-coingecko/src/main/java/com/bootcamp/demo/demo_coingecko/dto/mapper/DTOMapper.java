package com.bootcamp.demo.demo_coingecko.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.dto.CoinDTO;
import com.bootcamp.demo.demo_coingecko.dto.VueAppDTO;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;

@Component
public class DTOMapper {

  public CoinDTO map(MarketDTO marketDTO) {
    return CoinDTO.builder().id(marketDTO.getId()).symbol(marketDTO.getSymbol())
        .name(marketDTO.getName()).image(marketDTO.getImage())
        .currentPrice(marketDTO.getCurrentPrice())
        .marketCap(marketDTO.getMarketCap())
        .priceChange24h(marketDTO.getPriceChange24h())
        .priceChangePercentage24h(marketDTO.getPriceChangePercentage24h())
        .marketCapRank(marketDTO.getMarketCapRank())
        .totalVolume(marketDTO.getTotalVolume())
        .build();
  }

  public CoinDTO map(Coin coin) {
    return CoinDTO.builder().id(coin.getCoinId())
        .symbol(coin.getSymbol()) //
        .name(coin.getName()) //
        .image(coin.getImage()) //
        .currentPrice(coin.getCurrentPrice()) //
        .marketCap(coin.getMarketCap())
        .marketCapRank(coin.getMarketCapRank())
        .priceChange24h(coin.getPriceChange24h()) //
        .priceChangePercentage24h(coin.getPriceChangePercentage24h()) //
        .totalVolume(coin.getTotalVolume())
        .build();
  }

  public VueAppDTO map(CoinDTO coinDTO) {
    return VueAppDTO.builder().id(coinDTO.getId()).symbol(coinDTO.getSymbol())
        .name(coinDTO.getName()).image(coinDTO.getImage())
        .currentPrice(coinDTO.getCurrentPrice())
        .marketCap(coinDTO.getMarketCap())
        .marketCapRank(coinDTO.getMarketCapRank())
        .priceChange24h(coinDTO.getPriceChange24h())
        .priceChangePercentage24h(coinDTO.getPriceChangePercentage24h())
        .totalVolume(coinDTO.getTotalVolume())
        .build();
  }
}
