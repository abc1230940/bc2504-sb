package com.bootcamp.demo.demo_mte_caller.model.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ApiResp<T> {
  
  private String code; // "000000"
  private String message; // "success." 
  private T data;
  

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }


  private ApiResp(Builder<T> builder) { // 俾人一開OBJECT就出現呢個
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class Builder<T> {
    private String code; 
    private String message;  
    private T data;

    public Builder() {
    this.code = SysCode.OK.getCode();
    this.message = SysCode.OK.getMessage();
  }

    // public Builder<T> code(SysCode sysCode) {
    //   this.code = sysCode.getCode();
    //   return this;
    // }

    // public Builder<T> message(SysCode sysCode) {
    //   this.message = sysCode.getMessage();
    //   return this;
    // }

    public Builder<T> status(SysCode sysCode) {
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      return this;
    }

    public Builder<T> data(T data) {
      
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<T>(this);
    }
  }
}
