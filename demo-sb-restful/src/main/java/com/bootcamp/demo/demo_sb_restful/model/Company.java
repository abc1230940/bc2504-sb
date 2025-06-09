package com.bootcamp.demo.demo_sb_restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class Company {
  private String name;
  private String catchPhrase;
  private String bs;
}
