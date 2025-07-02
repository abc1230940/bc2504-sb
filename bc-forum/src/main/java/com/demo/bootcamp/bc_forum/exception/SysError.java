package com.demo.bootcamp.bc_forum.exception;

import lombok.Getter;

@Getter
public enum SysError {
  USER_NOT_FOUND(1L, "User not found"),;
  // TODO 以後有咩新的code都可以加上去 

  private final long errorCode;
  private final String errorMessage;

  private SysError(long errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  // handle the error after throw in GlobalExceptionHandler

  
}
