package com.bootcamp.demo.demo_mte_caller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.demo_mte_caller.model.dto.ScheduleDTO;

public interface MTROperation {
  
  @GetMapping("/call8080/line/{lineCode}/station/{stationCode}")
  ScheduleDTO getSchedule(@PathVariable String lineCode, @PathVariable String stationCode); 

}
