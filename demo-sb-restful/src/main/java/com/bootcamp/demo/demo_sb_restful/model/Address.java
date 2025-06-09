package com.bootcamp.demo.demo_sb_restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor
@Getter
@Builder

public class Address {
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private Geo geo;
}
