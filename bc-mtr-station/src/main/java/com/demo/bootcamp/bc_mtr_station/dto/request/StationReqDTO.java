package com.demo.bootcamp.bc_mtr_station.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class StationReqDTO {
  private String lineCode;
  private String stationCode;
  private String stationName;
  private String prev;
  private String next;

}
