package com.example.bootcamp.stock_market_project.config;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
// import com.example.bootcamp.stock_market_project.controller.StockOperation;

@Component
public class AppScheduler {
  // @Autowired
  // private StockOperation stockOperation;


  @Scheduled(cron = "0 */5 * * * *", zone = "Asia/Hong_Kong")
  public void update() throws InterruptedException {

    // this.stockOperation.getAllStockData();

  }

}
