package com.demo.bootcamp.bc_mtr_station.service;

import java.util.List;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;
import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;

public interface StationService {

  List<StationEntity> getAllStations();
  List<StationEntity> getStationsByLineEntity(LineEntity lineEntity);
  StationEntity create(StationEntity stationEntity);
  
}
