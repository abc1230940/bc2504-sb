package com.example.bootcamp.stock_market_heatmap_ui.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.bootcamp.stock_market_heatmap_ui.model.dto.HeatmapDTO;
import com.example.bootcamp.stock_market_heatmap_ui.service.HeatmapService;

@Service
public class HeatmapServiceImpl implements HeatmapService {
  @Value("${service.finnhub.host}")
  private String host;
  @Value("${service.finnhub.quote.version}")
  private String version;
  @Value("${service.finnhub.quote.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  public List<HeatmapDTO> fetchStockData() {

    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(this.host) //
        .pathSegment(this.version).path(this.endpoint) //
        .build().toUriString();

    System.out.println("url=" + url);

    HeatmapDTO[] heatmapDTOs =
        this.restTemplate.getForObject(url, HeatmapDTO[].class);
    return List.of(heatmapDTOs);

  }
}
