package com.bootcamp.demo.demo_mte_caller.model.dto;

import java.time.LocalDateTime;

// shift + cmd + o -> remove useless imports
// ! 不建議用同一個DTO封接收入地, 會受到對方的限制

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class ScheduleDTO {

  @JsonProperty(value = "sys_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime systemTime;
  @JsonProperty(value = "curr_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currentTime;
  @JsonProperty(value = "isdelay")
  private String isDelay;
  private Integer status;
  private String message;

  private Map<String, StationSchedule> data;
  
    @AllArgsConstructor
    @Getter
    @Builder

    public static class StationSchedule {
      @JsonProperty(value = "curr_time")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime currentTime;
      @JsonProperty(value = "sys_time")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime systemTime;
      @JsonProperty(value = "UP")
      private List<TrainData> upTrainDatas;
      @JsonProperty(value = "DOWN")
      private List<TrainData> downTrainDatas;
    

      @AllArgsConstructor
      @Getter
      @Builder

      public static class TrainData {
        private String seq;
        private String dest;
        private String plat;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime time;
        private String ttnt;
        private String valid;
        private String source;
      }


    
  }

}
