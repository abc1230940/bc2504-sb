package com.bootcamp.demo.demo_sb_restful.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserDTO {
  private Long id;
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
    private String phone;
    private String website;
    private Company company;

    @AllArgsConstructor
    @Getter
    @Builder
    public static class Company {
      private String name;
      private String catchPhrase;
      private String bs;
    }
  }
