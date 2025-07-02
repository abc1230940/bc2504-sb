package com.demo.bootcamp.bc_mtr_station.exception;

import lombok.Getter;

@Getter

public class LineNotFoundException extends RuntimeException {
  private String errorCode;

  public static LineNotFoundException of(SysError sysError) { // ! 記得返呢個封裝技巧，因為可以唔駛再寫new
    return new LineNotFoundException(sysError);
  }

  private LineNotFoundException(SysError sysError) {
    super(sysError.getErrorMessage());
    this.errorCode = sysError.getErrorCode();
  }
}
