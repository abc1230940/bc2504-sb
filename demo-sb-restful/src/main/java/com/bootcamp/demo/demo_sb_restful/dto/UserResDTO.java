package com.bootcamp.demo.demo_sb_restful.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// for Deserialization
@AllArgsConstructor
@Getter
@Builder

public class UserResDTO {
  private String name;
  private String username;
  private String email;
  private Address address;

  @AllArgsConstructor
  @Getter
  @Builder
  public static class Address {
      private String street;
      private String suite;
      private String city;
      private String zipcode;
      private Geo geo;

      @AllArgsConstructor
      @Getter
      @Builder
        public static class Geo {
          private String lat;
          private String lng;
        }
  }
    
}
