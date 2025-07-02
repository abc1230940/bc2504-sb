package com.demo.bootcamp.bc_mtr_station.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.demo.bootcamp.bc_mtr_station.dto.ErrorDTO;
import com.demo.bootcamp.bc_mtr_station.model.ApiResp;
import com.demo.bootcamp.bc_mtr_station.model.SysCode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = LineNotFoundException.class)
  public ApiResp<ErrorDTO> handleLineNotFoundException(
      LineNotFoundException ex) {
    ErrorDTO errorDTO = ErrorDTO.builder() //
        .code(ex.getErrorCode()) //
        .message(SysError.LINE_NOT_FOUND.getErrorMessage()) //
        .build();
    return ApiResp.<ErrorDTO>builder().status(SysCode.FAILED).data(errorDTO).build();
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 話返俾人知係邊個value -> 400(正常procees但冇result) 404 -> url問題，no this endpoint
  @ExceptionHandler(value = InvalidInputException.class)
  public ErrorDTO handleInvalidInputException(InvalidInputException ex) {
    return ErrorDTO.builder() //
        .code(ex.getErrorCode()) //
        .message(SysError.INVALID_INPUT.getErrorMessage() + " "
            + ex.getExtraMessage()) //
        .build();

  }

}
