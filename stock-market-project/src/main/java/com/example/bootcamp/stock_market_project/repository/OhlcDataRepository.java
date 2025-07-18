package com.example.bootcamp.stock_market_project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bootcamp.stock_market_project.entity.OhlcDataEntity;

@Repository
public interface OhlcDataRepository
    extends JpaRepository<OhlcDataEntity, Long> {

  List<OhlcDataEntity> findByCode(String code);

}
