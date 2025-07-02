package com.bootcamp.demo.demo_coingecko.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.lib.RedisManager;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;
import com.bootcamp.demo.demo_coingecko.model.mapper.ModelMapper;
import com.bootcamp.demo.demo_coingecko.redis.dto.RedisCoinDTO;
import com.bootcamp.demo.demo_coingecko.redis.mapper.RedisMapper;
import com.bootcamp.demo.demo_coingecko.repository.CoinRepository;
import com.bootcamp.demo.demo_coingecko.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CoinServiceImpl implements CoinService {
  @Value("${service.coingecko.host.demo}")
  private String host;
  @Value("${service.coingecko.api.apikey-name}")
  private String apiKeyName;
  @Value("${service.coingecko.api.apikey-value}")
  private String apiKeyValue;
  @Value("${service.coingecko.api.markets.version}")
  private String version;
  @Value("${service.coingecko.api.markets.endpoint}")
  private String endpoint;

  @Autowired
  private CoinRepository coinRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper; // object -> String
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private RedisMapper redisMapper;
  @Autowired
  private RedisManager redisManager;

  @Override
  public List<Coin> getMarketWithCache(String currency,
      List<String> targetCoins) throws JsonProcessingException {
    // ! Read Through Pattern:

    List<Coin> coins = new ArrayList<>();
    for (String targetCoin : targetCoins) {

      // ! Step 1: Find from cache, if found, return
      String coinKey = "market-" + targetCoin;
      String json = this.redisTemplate.opsForValue().get(coinKey);
      if (json != null) {
        RedisCoinDTO redisCoinDTO =
            this.objectMapper.readValue(json, RedisCoinDTO.class);
        Coin coin = this.modelMapper.map(redisCoinDTO);
        coins.add(coin);
        continue;
      } // 似hashmap拎key

      // ! Step 2: Not found -> find from DB, if found, write into cache
      CoinEntity coinEntity = this.coinRepository.findByCoinId(targetCoin)
          .orElseThrow(() -> new RuntimeException("INVALID INPUT"));
      // ! Step 2a: prepare the list return to client
      Coin coin = this.modelMapper.map(coinEntity);
      coins.add(coin);
      // ! Step 2b: write into cache
      RedisCoinDTO redisCoinDTO = this.redisMapper.map(coinEntity);
      // String coinJsonStr = this.objectMapper.writeValueAsString(redisCoinDTO);
      // this.redisTemplate.opsForValue().set(coinKey, coinJsonStr, Duration.ofSeconds(30));
      this.redisManager.write(redisCoinDTO, coinKey, 30);

    }

    // ! Step 3: return the result
    return coins;
  }


  @Override
  public List<MarketDTO> getMarkets(String currency, List<String> coins) {
    String coinList = String.join(",", coins);

    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(this.host) //
        .pathSegment(this.version).path(this.endpoint) //
        .queryParam("vs_currency", currency).queryParam("ids", coinList)
        .queryParam(apiKeyName, apiKeyValue).build().toUriString();

    System.out.println("url=" + url);

    MarketDTO[] marketDTOs =
        this.restTemplate.getForObject(url, MarketDTO[].class);
    return List.of(marketDTOs);
  }

  @Override
  public List<CoinEntity> create(List<CoinEntity> coinEntities) {
    return this.coinRepository.saveAll(coinEntities);
  }

  @Override
  public void deleteAll() {
    this.coinRepository.deleteAll();
  }
}
