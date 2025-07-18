package com.example.bootcamp.stock_market_data_provider.dto.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Component;
import com.example.bootcamp.stock_market_data_provider.dto.StockDataRespDTO;
import com.example.bootcamp.stock_market_data_provider.model.dto.StockDataDTO;

@Component
public class DTOMapper {

  public StockDataRespDTO map(StockDataDTO stockDataDTO, String symbol) {
    LocalDateTime timestamp = stockDataDTO.getTimestamp() != null
        ? LocalDateTime.ofInstant(
            Instant.ofEpochSecond(stockDataDTO.getTimestamp()),
            ZoneId.of("Asia/Hong_Kong"))
        : LocalDateTime.now(ZoneId.of("Asia/Hong_Kong"));

    return StockDataRespDTO.builder().symbol(symbol)
        .currentPrice(stockDataDTO.getCurrentPrice())
        .change(stockDataDTO.getChange())
        .percentChange(stockDataDTO.getPercentChange())
        .highPriceOfTheDay(stockDataDTO.getHighPriceOfTheDay())
        .lowPriceOfTheDay(stockDataDTO.getLowPriceOfTheDay())
        .openPriceOfTheDay(stockDataDTO.getOpenPriceOfTheDay())
        .previousClosePrice(stockDataDTO.getPreviousClosePrice())
        .timestamp(timestamp).build();

  }
}
