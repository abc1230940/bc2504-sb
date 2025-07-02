package com.bootcamp.demo.demo_mte_caller.model.dto;

public enum SysCode {
  
   OK("000000", "success."), //
   FAIL("999999", "fail.") //
   ;

  private String code;
  private String message;

  private SysCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
