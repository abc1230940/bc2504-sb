package com.bootcamp.demo.demo_sb_helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class StringController {

  // http://localhost:8080/sum2?a=hello&b=world
  @GetMapping(value = "/sum2")
  public Integer sum2(@RequestParam String x, @RequestParam String y) { // ! 要記得所有入嚟的都係String，但都可以是Integer, 因為會約定會變成Integer
    try {
      int a = Integer.parseInt(x);
      int b = Integer.parseInt(y);
      return a + b;
    } catch (NumberFormatException e) {
      return -1;
    }
  }
}
