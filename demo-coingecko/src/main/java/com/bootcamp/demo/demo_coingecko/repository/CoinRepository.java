package com.bootcamp.demo.demo_coingecko.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;


@Repository
public interface CoinRepository extends JpaRepository<CoinEntity, Long> {
  Optional<CoinEntity> findByCoinId(String coinId);
}
