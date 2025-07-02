package com.demo.bootcamp.bc_mtr_station.model;

import lombok.Getter;

@Getter

public enum Scheme {
  HTTP("http"),
  HTTPS("https");

  private final String name;

  private Scheme(String name) {

    this.name = name;

  }
}
