package com.bootcamp.demo.demo_mte_caller.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_mte_caller.controller.MTROperation;
import com.bootcamp.demo.demo_mte_caller.model.dto.ScheduleDTO;
import com.bootcamp.demo.demo_mte_caller.service.MTRService;

@RestController
public class MTRController implements MTROperation {
  @Autowired
  private MTRService mtrService;

  @Override
  public ScheduleDTO getSchedule(String lineCode, String stationCode) {
    return this.mtrService.getSchedule(lineCode, stationCode);
  }
}
