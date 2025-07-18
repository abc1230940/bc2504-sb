package com.example.bootcamp.stock_market_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.example.bootcamp.stock_market_project.entity.OhlcDataEntity;
import com.example.bootcamp.stock_market_project.model.OhlcData;
import com.example.bootcamp.stock_market_project.model.mapper.ModelMapper;
import com.example.bootcamp.stock_market_project.redis.dto.RedisOhlcDataDTO;
import com.example.bootcamp.stock_market_project.redis.mapper.RedisMapper;
import com.example.bootcamp.stock_market_project.repository.OhlcDataRepository;
import com.example.bootcamp.stock_market_project.service.OhlcService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OhlcServiceImpl implements OhlcService {
  @Autowired
  private OhlcDataRepository ohlcDataRepository;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private RedisMapper redisMapper;

  @Override
  public List<OhlcDataEntity> getOhlcData(String code) {
    return this.ohlcDataRepository.findByCode(code);
  }

  @Override
  public List<OhlcData> getOhlcDataWithCache(String code)
      throws JsonProcessingException {

    List<OhlcData> ohlcDatas = new ArrayList<>();
    String redisKey = "symbol-" + code;

    String json = this.redisTemplate.opsForValue().get(redisKey);
    if (json != null) {
      RedisOhlcDataDTO[] redisOhlcDataDTOs =
          this.objectMapper.readValue(json, RedisOhlcDataDTO[].class);
      List<RedisOhlcDataDTO> redisOhlcDataDTOList = List.of(redisOhlcDataDTOs);
      ohlcDatas = redisOhlcDataDTOList.stream()
          .map(r -> this.modelMapper.map(r)).collect(Collectors.toList());
    }

    List<OhlcDataEntity> ohlcDataEntities =
        this.ohlcDataRepository.findByCode(code);
    List<RedisOhlcDataDTO> redisDtos = ohlcDataEntities.stream()
        .map(e -> this.redisMapper.map(e)).collect(Collectors.toList());
    String jsonToCache = objectMapper.writeValueAsString(redisDtos);
    redisTemplate.opsForValue().set(redisKey, jsonToCache, 7, TimeUnit.DAYS);

    return ohlcDatas;
  }

  @Override
  public void deleteAll() {
    this.ohlcDataRepository.deleteAll();
  }

}
