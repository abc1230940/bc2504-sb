package com.example.bootcamp.stock_market_data_provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.bootcamp.stock_market_data_provider.model.dto.StockDataDTO;
import com.example.bootcamp.stock_market_data_provider.service.StockDataService;

@Service
public class StockDataServiceImpl implements StockDataService {
  @Value("${service.finnhub.host}")
  private String host;
  @Value("${service.finnhub.api.apikey-name}")
  private String apiKeyName;
  @Value("${service.finnhub.api.apikey-value}")
  private String apiKeyValue;
  @Value("${service.finnhub.api.quote.version}")
  private String version;
  @Value("${service.finnhub.api.quote.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public StockDataDTO getStockData(String symbol) {

    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(this.host) //
        .pathSegment(this.version).path(this.endpoint) //
        .queryParam("symbol", symbol) //
        .queryParam(apiKeyName, apiKeyValue).build().toUriString();

    System.out.println("url=" + url);

    StockDataDTO stockDataDTO =
        this.restTemplate.getForObject(url, StockDataDTO.class);
    return stockDataDTO;

  }
}
