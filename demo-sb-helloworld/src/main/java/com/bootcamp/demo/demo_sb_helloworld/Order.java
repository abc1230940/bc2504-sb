package com.bootcamp.demo.demo_sb_helloworld;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Order {
  private long id;
  private int amount;
  
}
