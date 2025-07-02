package com.demo.bootcamp.bc_mtr_station.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;
import com.demo.bootcamp.bc_mtr_station.repository.LineRepository;
import com.demo.bootcamp.bc_mtr_station.service.LineService;

@Service
public class LineServiceImpl implements LineService {
  @Autowired
  private LineRepository lineRepository;

  @Override
  public Optional<LineEntity> findByLineId(Long id) {
    return this.lineRepository.findById(id);
  }

  @Override
  public Optional<LineEntity> findByLineCode(String lineCode) {
    return this.lineRepository.findByLineCode(lineCode);
  }

   @Override
  public boolean isExist(String lineCode) {
    return this.lineRepository.existsByLineCode(lineCode);
  }
  

}
