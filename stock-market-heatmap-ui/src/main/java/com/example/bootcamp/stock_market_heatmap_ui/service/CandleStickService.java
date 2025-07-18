package com.example.bootcamp.stock_market_heatmap_ui.service;

import java.util.List;
import com.example.bootcamp.stock_market_heatmap_ui.model.dto.CandleStickDTO;

public interface CandleStickService {
  List<CandleStickDTO> fetchHistoryData(String symbol);
}
