package com.bootcamp.demo.demo_coingecko.lib;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.redis.dto.RedisCoinDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RedisManager {
  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;
  

  public void write(RedisCoinDTO redisCoinDTO, String coinKey, int second)
      throws JsonProcessingException {
    String coinJsonStr = this.objectMapper.writeValueAsString(redisCoinDTO);
    this.redisTemplate.opsForValue().set(coinKey, coinJsonStr,
        Duration.ofSeconds(30));
  }
}
