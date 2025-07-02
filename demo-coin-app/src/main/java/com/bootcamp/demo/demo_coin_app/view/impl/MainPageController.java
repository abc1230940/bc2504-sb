package com.bootcamp.demo.demo_coin_app.view.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.bootcamp.demo.demo_coin_app.model.dto.CoinData;
import com.bootcamp.demo.demo_coin_app.service.MainPageService;
import com.bootcamp.demo.demo_coin_app.view.MainPageOperation;

@Controller // ! return html
public class MainPageController implements MainPageOperation {
  @Autowired
  private MainPageService mainPageService;


  @Override
  public String init() {
    return "hello"; // ! the name of html file
  }

  @Override
  public String loadCoinPage(Model model) {
    List<CoinData> coinDataList = this.mainPageService.fetchCoinData();
    model.addAttribute("coinList", coinDataList);
    return "coindata";

  }

  
}
