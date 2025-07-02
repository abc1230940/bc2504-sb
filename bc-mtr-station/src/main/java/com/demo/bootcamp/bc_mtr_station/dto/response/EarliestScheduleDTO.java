package com.demo.bootcamp.bc_mtr_station.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class EarliestScheduleDTO {
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currentTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime systemTime;
  private String currentStation;
  List<TrainInfo> trains;

  @AllArgsConstructor
  @Getter
  @Builder

  public static class TrainInfo {
    private String destination;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalTime;
    private String direction;
  }
}
