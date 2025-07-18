package com.example.bootcamp.stock_market_heatmap_ui.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CandleStickOperation {

  @GetMapping("/candlestick")
  public String loadCandleStick(@RequestParam String symbol, Model model);
}
