package com.example.gateway;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;


@Component
public class RatesCollector {

    private final ExchangeRateRepository exchangeRateRepository;
    private final FixerIoService fixerIoService;

    public RatesCollector(ExchangeRateRepository exchangeRateRepository, FixerIoService fixerIoService) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.fixerIoService = fixerIoService;
    }

    @Scheduled(cron = "0 0 * * * *") // hour
    public void collectRates() {
    	
    	System.out.println("collectRates has been called");

        FixerIoResponse fixerIoResponse = fixerIoService.getLatestRates();

        if (fixerIoResponse != null) {
        	Map<String, BigDecimal> linkedHashMap = fixerIoResponse.getRates();
        	Set<String> keys = linkedHashMap.keySet();
        	 
        	 for (String key : keys) {
        		 BigDecimal value = linkedHashMap.get(key);
        		 
        		 ExchangeRate exchangeRate = new ExchangeRate();
        		 
                 exchangeRate.setCurrency(key);
                 exchangeRate.setRate(value);
                 exchangeRate.setDate(new Date());
                 
                 exchangeRateRepository.save(exchangeRate);
             }
        }
    }
}
