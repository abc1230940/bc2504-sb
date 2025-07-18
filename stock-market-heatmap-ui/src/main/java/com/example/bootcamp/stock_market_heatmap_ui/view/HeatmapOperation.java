package com.example.bootcamp.stock_market_heatmap_ui.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface HeatmapOperation {

  @GetMapping(value = "/heatmap")
  String loadHeatmap(Model model);
}
