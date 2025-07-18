package com.example.bootcamp.stock_market_heatmap_ui.view.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.bootcamp.stock_market_heatmap_ui.model.dto.CandleStickDTO;
import com.example.bootcamp.stock_market_heatmap_ui.service.CandleStickService;
import com.example.bootcamp.stock_market_heatmap_ui.view.CandleStickOperation;


@Controller
public class CandleStickController implements CandleStickOperation {

  @Autowired
  private CandleStickService candleStickService;

  public String loadCandleStick(String symbol, Model model) {
    List<CandleStickDTO> candleStickDTOs =
        this.candleStickService.fetchHistoryData(symbol);
    model.addAttribute("candleStickData", candleStickDTOs);
    model.addAttribute("symbol", symbol);
    return "candlestick"; // This should match a Thymeleaf template
  }
}

