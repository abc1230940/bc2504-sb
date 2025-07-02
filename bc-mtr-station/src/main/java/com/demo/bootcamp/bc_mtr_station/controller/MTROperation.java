package com.demo.bootcamp.bc_mtr_station.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.demo.bootcamp.bc_mtr_station.model.ApiResp;
import com.demo.bootcamp.bc_mtr_station.model.dto.ScheduleDTO;

public interface MTROperation {

  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/line/{lineCode}/station/{stationCode}")
  ApiResp<ScheduleDTO> getScheduleDTO(@PathVariable String lineCode, @PathVariable String stationCode);

  // earliestschedule?sta=TKO
  // @ResponseStatus(value = HttpStatus.OK)
  // @GetMapping(value = "/earliestschedule")
  // EarliestScheduleDTO getEarliestScheduleDTO(@RequestParam("sta") String stationCode);
}
