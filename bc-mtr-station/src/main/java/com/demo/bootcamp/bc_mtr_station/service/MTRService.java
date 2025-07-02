package com.demo.bootcamp.bc_mtr_station.service;

import com.demo.bootcamp.bc_mtr_station.model.dto.ScheduleDTO;

// 1. call external API
// 2. give your service

public interface MTRService {
  ScheduleDTO getSchedule(String line, String station);
  // EarliestScheduleDTO getEarliestSchedule(String station);

}
