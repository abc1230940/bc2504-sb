package com.bootcamp.demo.demo_coin_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_coin_app.entity.CoinPriceEntity;

@Repository
public interface CoinPriceRepository extends JpaRepository<CoinPriceEntity, Long> {
  
}
