package com.example.gateway;

import java.math.BigDecimal;

public class ExchangeRateResponse {
	
	private BigDecimal exchangeRateData;

	public void setExchangeRateData(BigDecimal currencyData) {
		this.exchangeRateData = currencyData;
	}
	
	public BigDecimal getExchangeRateData() {
		return this.exchangeRateData;
	}
}
