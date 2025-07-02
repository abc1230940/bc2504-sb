package com.demo.bootcamp.bc_forum.exception;

public class UserNotFoundException extends RuntimeException {
  private long errorCode;

  public UserNotFoundException(SysError sysError) { // 不能被人任意更改
    super(sysError.getErrorMessage());
    this.errorCode = sysError.getErrorCode();
  }

  
  
}
