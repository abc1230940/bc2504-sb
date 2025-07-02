package com.demo.bootcamp.bc_mtr_station.dto.mapper;


import org.springframework.stereotype.Component;

import com.demo.bootcamp.bc_mtr_station.dto.response.StationRepDTO;

import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;


@Component
public class dtoMapper {

  public StationRepDTO map(StationEntity stationEntity) {
    return StationRepDTO.builder().stationCode(stationEntity.getStationCode())
        .name(stationEntity.getName()).prev(stationEntity.getPrev())
        .next(stationEntity.getNext())
        .lineName(stationEntity.getLineEntity().getName()).build();
  }

  // public EarliestScheduleDTO map(ScheduleDTO scheduleDTO, List<TrainInfo> trains, ) {
  //   List<TrainInfo> trains = new ArrayList<>();
  //   trains.add(TrainInfo.builder().destination(scheduleDTO.))
  //   return EarliestScheduleDTO.builder().currentTime(scheduleDTO.getCurrentTime()).systemTime(scheduleDTO.getSystemTime()).trains(trains).build();
  // }
}
