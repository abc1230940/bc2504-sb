package com.bootcamp.demo.demo_sb_helloworld;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder

public class Person {
  
  private long id;
  private String name;
  private int age;

  
}
