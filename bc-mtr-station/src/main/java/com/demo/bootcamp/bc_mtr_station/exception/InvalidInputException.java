package com.demo.bootcamp.bc_mtr_station.exception;

import lombok.Getter;

@Getter

public class InvalidInputException extends RuntimeException {
  private String errorCode;
  private String extraMessage;

  public InvalidInputException(SysError sysError, String extraMessage) {
    super(sysError.getErrorMessage());
    this.errorCode = sysError.getErrorCode();
    this.extraMessage = extraMessage;
  }
  
}
