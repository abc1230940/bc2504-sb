package com.bootcamp.demo.demo_coingecko.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.entity.mapper.EntityMapper;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;
import com.bootcamp.demo.demo_coingecko.service.CoinService;

@Component
public class AppStartRunner implements CommandLineRunner {
    @Autowired
    private CoinService coinService;

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public void run(String... args) throws Exception {

        String currency = "usd";
        String coin = "bitcoin,ethereum";
        String[] coins = coin.split(",");
        List<MarketDTO> marketDTOs =
                this.coinService.getMarkets(currency, List.of(coins));
        List<CoinEntity> coinEntities = marketDTOs.stream()
                .map(marketDTO -> this.entityMapper.map(marketDTO))
                .collect(Collectors.toList());
        if (coinEntities.size() > 0) {
            this.coinService.deleteAll();
            this.coinService.create(coinEntities);
        }


    }

}
