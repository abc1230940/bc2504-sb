package com.example.bootcamp.stock_market_project.dto.mapper;

import org.springframework.stereotype.Component;
import com.example.bootcamp.stock_market_project.dto.AllStockDataRespDTO;
import com.example.bootcamp.stock_market_project.dto.OhlcDataRespDTO;
import com.example.bootcamp.stock_market_project.entity.OhlcDataEntity;
import com.example.bootcamp.stock_market_project.model.OhlcData;
import com.example.bootcamp.stock_market_project.model.dto.StockDTO;

@Component
public class DTOMapper {

  public AllStockDataRespDTO map(StockDTO stockDTO) {
    return AllStockDataRespDTO.builder().symbol(stockDTO.getSymbol())
        .currentPrice(stockDTO.getCurrentPrice()).change(stockDTO.getChange())
        .percentChange(stockDTO.getPercentChange())
        .highPriceOfTheDay(stockDTO.getHighPriceOfTheDay())
        .lowPriceOfTheDay(stockDTO.getLowPriceOfTheDay())
        .openPriceOfTheDay(stockDTO.getOpenPriceOfTheDay())
        .previousClosePrice(stockDTO.getPreviousClosePrice())
        .timestamp(stockDTO.getTimestamp()).build();
  }

  public OhlcDataRespDTO map(OhlcDataEntity ohlcDataEntity) {
    return OhlcDataRespDTO.builder().code(ohlcDataEntity.getCode())
        .date(ohlcDataEntity.getDate()).open(ohlcDataEntity.getOpen())
        .high(ohlcDataEntity.getHigh()).low(ohlcDataEntity.getLow())
        .close(ohlcDataEntity.getClose()).volume(ohlcDataEntity.getVolume())
        .build();
  }

  public OhlcDataRespDTO map(OhlcData ohlcData) {
    return OhlcDataRespDTO.builder().code(ohlcData.getCode())
        .date(ohlcData.getDate()).open(ohlcData.getOpen())
        .high(ohlcData.getHigh()).low(ohlcData.getLow())
        .close(ohlcData.getClose()).volume(ohlcData.getVolume()).build();
  }
}
