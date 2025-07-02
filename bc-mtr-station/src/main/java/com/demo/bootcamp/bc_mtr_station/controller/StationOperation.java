package com.demo.bootcamp.bc_mtr_station.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.demo.bootcamp.bc_mtr_station.dto.request.StationReqDTO;
import com.demo.bootcamp.bc_mtr_station.dto.response.StationRepDTO;
import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;

public interface StationOperation {
  
  @ResponseStatus(value = HttpStatus.OK) // 200
  @GetMapping(value = "/mtr/stations")
  List<StationRepDTO> getAllStations();

  @ResponseStatus(value = HttpStatus.CREATED) // 201
  @GetMapping(value = "/mtr/lineid/{id}/stations")
  List<StationRepDTO> getStationsByLineId(@PathVariable Long id);

  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping(value = "/mtr/line/{lineCode}/station") // ! {}個名一定要同pathVariable一樣
  StationEntity create(@PathVariable String lineCode, @RequestBody StationReqDTO stationRepDTO);

  
}
