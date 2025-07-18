package com.example.bootcamp.stock_market_heatmap_ui.view.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bootcamp.stock_market_heatmap_ui.model.dto.HeatmapDTO;
import com.example.bootcamp.stock_market_heatmap_ui.service.HeatmapService;

@Controller
public class HeatmapController {

  @Autowired
  private HeatmapService heatmapService;


  @GetMapping("/heatmap")
  public String loadHeatmap(Model model) {
    List<HeatmapDTO> heatmapDTOs = this.heatmapService.fetchStockData();
    model.addAttribute("heatmap", heatmapDTOs);
    return "heatmap"; // This should match a Thymeleaf template
  }

}
