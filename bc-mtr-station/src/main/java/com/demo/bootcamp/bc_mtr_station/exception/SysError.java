package com.demo.bootcamp.bc_mtr_station.exception;

import lombok.Getter;

@Getter

public enum SysError {
  LINE_NOT_FOUND("000001", "The line is not found."),
  STATION_NOT_FOUND("000002", "The station is not found"),
  INVALID_INPUT("000003", "Invalid input.")
  ;

  private String errorCode;
  private String errorMessage;

  private SysError(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
  
}
