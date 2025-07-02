package com.demo.bootcamp.bc_mtr_station.service;

import java.util.Optional;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;

public interface LineService {
  
  Optional<LineEntity> findByLineId(Long id);
  Optional<LineEntity> findByLineCode(String lineCode);
  boolean isExist(String lineCode);
 
}
