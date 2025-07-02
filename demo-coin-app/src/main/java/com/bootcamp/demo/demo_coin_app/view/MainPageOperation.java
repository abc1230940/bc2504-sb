package com.bootcamp.demo.demo_coin_app.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface MainPageOperation {
  @GetMapping(value = "/index")
  String init();

  @GetMapping(value = "/coinpage")
  String loadCoinPage(Model model);

  
  
}
