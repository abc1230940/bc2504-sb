package com.demo.bootcamp.bc_mtr_station.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bootcamp.bc_mtr_station.controller.StationOperation;
import com.demo.bootcamp.bc_mtr_station.dto.mapper.dtoMapper;
import com.demo.bootcamp.bc_mtr_station.dto.request.StationReqDTO;
import com.demo.bootcamp.bc_mtr_station.dto.response.StationRepDTO;
import com.demo.bootcamp.bc_mtr_station.entity.LineEntity;
import com.demo.bootcamp.bc_mtr_station.entity.StationEntity;
import com.demo.bootcamp.bc_mtr_station.entity.mapper.EntityMapper;
import com.demo.bootcamp.bc_mtr_station.exception.InvalidInputException;
import com.demo.bootcamp.bc_mtr_station.exception.LineNotFoundException;
import com.demo.bootcamp.bc_mtr_station.exception.SysError;
import com.demo.bootcamp.bc_mtr_station.service.LineService;
import com.demo.bootcamp.bc_mtr_station.service.StationService;

@RestController
public class StationController implements StationOperation {
  @Autowired
  private LineService lineService;
  @Autowired
  private StationService stationService;
  @Autowired
  private dtoMapper dtoMapper;
  @Autowired
  private EntityMapper entityMapper;

  // ! 在這裡應該做entity -> RepDTO

  @Override
  public List<StationRepDTO> getAllStations() {
    return this.stationService.getAllStations().stream()
        .map(stationEntity -> this.dtoMapper.map(stationEntity))
        .collect(Collectors.toList());
  }

  @Override
  public List<StationRepDTO> getStationsByLineId(Long id) {
    LineEntity lineEntity = this.lineService.findByLineId(id)
        .orElseThrow(() -> LineNotFoundException.of(SysError.LINE_NOT_FOUND));
    return this.stationService.getStationsByLineEntity(lineEntity).stream()
        .map(stationEntity -> this.dtoMapper.map(stationEntity))
        .collect(Collectors.toList());
  }

  @Override
  public StationEntity create(String lineCode, StationReqDTO stationReqDTO) {

    if (!this.lineService.isExist(lineCode)) {
      throw LineNotFoundException.of(SysError.LINE_NOT_FOUND);
    }

    if (lineCode == null) {
      throw new InvalidInputException(SysError.INVALID_INPUT,
          "lineCode cannot be null.");
    }
    if (stationReqDTO.getLineCode() == null
        || !stationReqDTO.getLineCode().matches("^[A-Z]{3}$")) {
      throw new InvalidInputException(SysError.INVALID_INPUT,
          "lineCode cannot be null and must be 3 CAPITAL LETTERS");
    }
    if (!stationReqDTO.getLineCode()
        .matches("AEL|TCL|TML|TKL|EAL|SIL|TWL|ISL|KTL|DRL")) {
      throw new InvalidInputException(SysError.INVALID_INPUT,
          "lineCode must be AEL or TCL or TML or TKL or EAL or SIL or TWL or ISL or KTL or DRL");
    }
    if (stationReqDTO.getStationCode() == null
        || !stationReqDTO.getStationCode().matches("^[A-Z]{3}$")) {
      throw new InvalidInputException(SysError.INVALID_INPUT,
          "stationCode cannot be null and must be 3 CAPITAL LETTERS.");
    }
    if (stationReqDTO.getStationName() == null
        || !stationReqDTO.getStationName().matches("^[A-Za-z ]{1,50}$")) {
      throw new InvalidInputException(SysError.INVALID_INPUT,
          "staionName must be within 50 characters long");
    }
    if (stationReqDTO.getPrev() != null
        && !stationReqDTO.getPrev().matches("^[A-Z]{3}$")) {
      throw new InvalidInputException(SysError.INVALID_INPUT,
          "station cannot be null and must be 3 CAPITAL LETTERS.");
    }
    if (stationReqDTO.getNext() != null
        && !stationReqDTO.getNext().matches("^[A-Z]{3}$")) {
      throw new InvalidInputException(SysError.INVALID_INPUT,
          "station cannot be null and must be 3 CAPITAL LETTERS.");
    }

    LineEntity lineEntity = this.lineService.findByLineCode(lineCode).get();
    StationEntity stationEntity =
        this.entityMapper.map(stationReqDTO, lineEntity);
    return this.stationService.create(stationEntity);
  }


}
