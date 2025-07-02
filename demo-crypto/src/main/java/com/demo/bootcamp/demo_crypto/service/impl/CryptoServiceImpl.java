package com.demo.bootcamp.demo_crypto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.demo.bootcamp.demo_crypto.model.dto.CoinDTO;
import com.demo.bootcamp.demo_crypto.service.CryptoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CryptoServiceImpl implements CryptoService {
  @Value("${service.coingecko.host}")
  private String host;
  @Value("${service.coingecko.port}")
  private String port;
  @Value("${service.coingecko.api.coindata.version}")
  private String version;
  @Value("${service.coingecko.api.coindata.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinDTO> getCoinfromGecko(String currency, List<String> coins) throws JsonProcessingException {
    
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(host) //
        // .pathSegment(version) //
        .port(this.port)
        .path(endpoint) //
        .queryParam("currency", currency)
        .queryParam("coin", String.join(",", coins))
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    return List.of(this.restTemplate.getForObject(url, CoinDTO[].class));
  
  }
}
