package com.demo.bootcamp.bc_calculator.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.demo.bootcamp.bc_calculator.dto.ErrorDTO;

// ! Handle unhappy flow

@RestControllerAdvice // @ControllerAdviser + @ResponseBody
public class GlobalExceptionHandler { 
  @ExceptionHandler(value = NumberFormatException.class)
  public ErrorDTO handleNumberFormatException(NumberFormatException ex) { // ! all NumberFormatException in this system都會去呢個方法，but try and catch can be customized by yourself
    return ErrorDTO.builder()
          .code(9)
          .message("Invalid Input")
          .build();
  }

  @ExceptionHandler(value = NotFoundException.class)
  public ErrorDTO handleNotFoundException(NotFoundException ex) { // ! all NumberFormatException in this system都會去呢個方法，but try and catch can be customized by yourself
    return ErrorDTO.builder()
          .code(10)
          .message("Invalid Input")
          .build();
  }

  @ExceptionHandler(value = IllegalArgumentException.class)
  public ErrorDTO handleIllegalArgumentException(IllegalArgumentException ex) { // ! all NumberFormatException in this system都會去呢個方法，but try and catch can be customized by yourself
    return ErrorDTO.builder()
          .code(11)
          .message("Invalid Input")
          .build();
  }

  @ExceptionHandler(value = Exception.class) // 終極包底
  public ErrorDTO handleOtherException(RuntimeException ex) { // ! all NumberFormatException in this system都會去呢個方法，but try and catch can be customized by yourself
    return ErrorDTO.builder()
          .code(99)
          .message("Unhandled Exception")
          .build();
  }
}
