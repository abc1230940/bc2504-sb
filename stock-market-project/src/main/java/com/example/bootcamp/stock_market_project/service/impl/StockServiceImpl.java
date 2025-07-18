package com.example.bootcamp.stock_market_project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.bootcamp.stock_market_project.model.dto.StockDTO;
// import com.example.bootcamp.stock_market_project.repository.StockRepository;
import com.example.bootcamp.stock_market_project.service.StockService;

@Service
public class StockServiceImpl implements StockService {
  @Value("${service.finnhub.host}")
  private String host;
  @Value("${service.finnhub.quote.version}")
  private String version;
  @Value("${service.finnhub.quote.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  // @Autowired
  // private StockRepository stockRepository;


  @Override
  public List<StockDTO> getAllStockData() {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(this.host) //
        .pathSegment(this.version).path(this.endpoint) //
        .build().toUriString();

    System.out.println("url=" + url);

    StockDTO[] stockDTOs =
        this.restTemplate.getForObject(url, StockDTO[].class);
    return List.of(stockDTOs);

  }
}
