package com.demo.bootcamp.bc_mtr_station.model;

import lombok.Getter;

@Getter

public enum SysCode {
  OK("000000", "success."),
  FAILED("999999", "failed");

  private String code;
  private String message;

  private SysCode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
