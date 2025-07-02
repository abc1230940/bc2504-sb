package com.bootcamp.demo.demo_coingecko.model;

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
