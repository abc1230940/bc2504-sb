package com.bootcamp.demo.demo_sb_restful.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.DemoSbRestfulApplication;
import com.bootcamp.demo.demo_sb_restful.controller.BeanOperation;

@RestController
public class BeanController implements BeanOperation {
  @Override
  public String[] getAllBeans() {
    return DemoSbRestfulApplication.context.getBeanDefinitionNames();
  }
}
