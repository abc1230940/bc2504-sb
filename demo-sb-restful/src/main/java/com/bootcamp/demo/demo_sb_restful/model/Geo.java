package com.bootcamp.demo.demo_sb_restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class Geo {
  private String lat;
  private String lng;
}
