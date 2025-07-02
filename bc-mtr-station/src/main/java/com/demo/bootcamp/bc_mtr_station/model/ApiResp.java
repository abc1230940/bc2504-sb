package com.demo.bootcamp.bc_mtr_station.model;

// Java 1.5 -> 沒有lombok都可以用
// 這個class應該要全世界都能用

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

  private ApiResp(Builder<T> builder) { // Step 1: 俾人一開OBJECT就出現呢個 -> private, 要人用builder()方法
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <T> Builder<T> builder() { // Step 2: 開啟builder method
    return new Builder<>();
  }

  public static class Builder<T> { // Step 3: Builder static class, fields全抄
    private String code; 
    private String message;  
    private T data;

    public Builder() { // 局限人開得都係OK
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

    public ApiResp<T> build() { // final step: return返ApiResp<T>(this)
      return new ApiResp<T>(this);
    }
  }
}
