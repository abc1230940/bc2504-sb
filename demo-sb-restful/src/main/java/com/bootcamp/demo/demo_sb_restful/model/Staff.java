package com.bootcamp.demo.demo_sb_restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder

public class Staff {
  private Long id;
  private String name;
  private Integer age;
}
