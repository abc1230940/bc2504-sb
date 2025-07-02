package com.demo.bootcamp.bc_mtr_station.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class StationRepDTO {
  private String stationCode;
  @JsonProperty(value = "stationName")
  private String name;
  private String prev;
  private String next;
  private String lineName;
}
