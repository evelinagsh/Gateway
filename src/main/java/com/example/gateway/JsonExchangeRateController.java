package com.example.gateway;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json_api")
public class JsonExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping("/current")
    public ResponseEntity<Object> getCurrentExchangeRate(@RequestBody ExchangeRateRequest request) {
        return exchangeRateService.handleCurrentExchangeRateRequest(request);
    }

    @PostMapping("/history")
    public ResponseEntity<Object> getCurrencyHistory(@RequestBody ExchangeRateHistoryRequest request) {
        return exchangeRateService.handleCurrencyHistoryRequest(request);
    }
}