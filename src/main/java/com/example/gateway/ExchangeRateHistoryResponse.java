package com.example.gateway;

import java.util.List;

public class ExchangeRateHistoryResponse {

    private List<ExchangeRate> currencyHistory;

    // Constructors, getters, and setters

    public List<ExchangeRate> getCurrencyHistory() {
        return currencyHistory;
    }

    public void setCurrencyHistory(List<ExchangeRate> currencyHistory) {
        this.currencyHistory = currencyHistory;
    }
}