package com.demo.bootcamp.bc_forum.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.demo.bootcamp.bc_forum.dto.ErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = UserNotFoundException.class)
  public ErrorDTO handleUserNotFoundException(UserNotFoundException ex) {
    return ErrorDTO.builder()
            .code(1)
            .message("User not found.")
            .build();
  }

  @ExceptionHandler(value = IllegalArgumentException.class)
  public ErrorDTO handleIllegalArgumentException(IllegalArgumentException ex) { // ! all NumberFormatException in this system都會去呢個方法，but try and catch can be customized by yourself
    return ErrorDTO.builder()
          .code(2)
          .message(ex.getMessage())
          .build();
  }

  @ExceptionHandler(value = Exception.class)
  public ErrorDTO handleOtherException(Exception ex) {
    return ErrorDTO.builder()
            .code(99)
            .message("Unhandled exceptions")
            .build();
  }
  
}
