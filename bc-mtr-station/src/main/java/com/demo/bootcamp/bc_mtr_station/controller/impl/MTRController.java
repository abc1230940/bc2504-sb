package com.demo.bootcamp.bc_mtr_station.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bootcamp.bc_mtr_station.controller.MTROperation;
import com.demo.bootcamp.bc_mtr_station.model.ApiResp;
import com.demo.bootcamp.bc_mtr_station.model.dto.ScheduleDTO;
import com.demo.bootcamp.bc_mtr_station.service.MTRService;

@RestController
public class MTRController implements MTROperation {
  @Autowired
  private MTRService mtrService;
  
  @Override
  public ApiResp<ScheduleDTO> getScheduleDTO(String lineCode, String stationCode) {
      ScheduleDTO scheduleDTO = this.mtrService.getSchedule(lineCode, stationCode);
      return ApiResp.<ScheduleDTO>builder()
            // .code(SysCode.OK.getCode())
            // .message(SysCode.OK.getMessage())
            // .ok()
            .data(scheduleDTO)
            .build();
  }
  

  // @Override
  // public EarliestScheduleDTO getEarliestScheduleDTO(String stationCode) {

  // }

}
