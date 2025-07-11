package com.example.bootcamp.stock_market_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bootcamp.stock_market_project.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

}
