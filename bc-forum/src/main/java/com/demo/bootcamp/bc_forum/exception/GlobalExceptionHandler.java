package com.demo.bootcamp.bc_forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.demo.bootcamp.bc_forum.dto.ErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = UserNotFoundException.class)
  public ErrorDTO handleUserNotFoundException(UserNotFoundException ex) {
    return ErrorDTO.builder()
            .code(1L)
            .message(ex.getMessage()) // 拎返enum裡面個messsage, 因為這個Exception的用途好多，所以先唔會寫死個code
            .build();
  }

  // ! 原本Java裡面已經存在的exception,在這裡加返個message上去就得
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = NumberFormatException.class)
  public ErrorDTO handleNumberFormatException(NumberFormatException ex) { // ! all NumberFormatException in this system都會去呢個方法，but try and catch can be customized by yourself
    return ErrorDTO.builder()
          .code(2L)
          .message("Invalid value.")
          .build();
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = RestClientException.class)
  public ErrorDTO handleRestRestClientException(RestClientException ex) {
    return ErrorDTO.builder()
            .code(3L)
            .message("message: RestTemplate Error - JsonPlaceHolder.")
            .build();
  }

  
}
