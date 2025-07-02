package com.demo.bootcamp.bc_mtr_station.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;
import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;
import com.demo.bootcamp.bc_mtr_station.repository.StationRepository;
import com.demo.bootcamp.bc_mtr_station.service.StationService;

@Service
public class StationServiceImpl implements StationService {
  @Autowired
  private StationRepository stationRepository;

  @Override
  public List<StationEntity> getAllStations() {
    return this.stationRepository.findAll();
  }

  @Override
  public List<StationEntity> getStationsByLineEntity(LineEntity lineEntity) {
    return this.stationRepository.findByLineEntity(lineEntity);
  }

  @Override
  public StationEntity create(StationEntity stationEntity) {
    return this.stationRepository.save(stationEntity);

  }



}
