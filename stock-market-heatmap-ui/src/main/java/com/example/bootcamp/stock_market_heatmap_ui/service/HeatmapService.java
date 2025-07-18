package com.example.bootcamp.stock_market_heatmap_ui.service;

import java.util.List;
import com.example.bootcamp.stock_market_heatmap_ui.model.dto.HeatmapDTO;

public interface HeatmapService {

  List<HeatmapDTO> fetchStockData();
}
