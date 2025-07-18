package com.example.bootcamp.stock_market_heatmap_ui.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.bootcamp.stock_market_heatmap_ui.model.dto.CandleStickDTO;
import com.example.bootcamp.stock_market_heatmap_ui.service.CandleStickService;

@Service
public class CandleStickServiceImpl implements CandleStickService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CandleStickDTO> fetchHistoryData(String symbol) {
    String url = "http://localhost:8081/ohlcdata?code=" + symbol;

    System.out.println("url=" + url);

    CandleStickDTO[] candleStickDTOs =
        this.restTemplate.getForObject(url, CandleStickDTO[].class);
    return List.of(candleStickDTOs);
  }
}
