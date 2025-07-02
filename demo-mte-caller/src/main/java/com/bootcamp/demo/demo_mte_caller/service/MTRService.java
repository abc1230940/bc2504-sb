package com.bootcamp.demo.demo_mte_caller.service;

import com.bootcamp.demo.demo_mte_caller.model.dto.ScheduleDTO;

public interface MTRService {
  // ! Call localhost: http://localhost:8080/line/{lineCode}/station/{stationCode}
  ScheduleDTO getSchedule(String lineCode, String stationCode);
  
}
