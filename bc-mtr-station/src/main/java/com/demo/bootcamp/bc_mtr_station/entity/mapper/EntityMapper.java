package com.demo.bootcamp.bc_mtr_station.entity.mapper;

import org.springframework.stereotype.Component;
import com.demo.bootcamp.bc_mtr_station.dto.request.StationReqDTO;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;
import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;


@Component
public class EntityMapper {

  public StationEntity map(StationReqDTO stationReqDTO, LineEntity lineEntity) {
  
    return StationEntity.builder().stationCode(stationReqDTO.getStationCode())
        .name(stationReqDTO.getStationName()).prev(stationReqDTO.getPrev())
        .next(stationReqDTO.getNext()).lineEntity(lineEntity).build();
  }

}
