package com.bootcamp.demo.demo_sb_restful.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// 計數 -> 可以用primitive

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Cat {
  public static List<Cat> cats = new ArrayList<>();

  private Long id;
  private String name;
  private int age;
}

