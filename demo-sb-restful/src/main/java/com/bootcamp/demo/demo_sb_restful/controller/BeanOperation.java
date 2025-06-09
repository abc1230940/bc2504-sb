package com.bootcamp.demo.demo_sb_restful.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
  @GetMapping(value = "/beans")
  String[] getAllBeans();
  
}
