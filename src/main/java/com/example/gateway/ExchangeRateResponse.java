package com.example.gateway;

import java.math.BigDecimal;
import java.util.Date;

public class ExchangeRateResponse {
	
	private BigDecimal rate;
	private Date date;

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	public BigDecimal getRate() {
		return this.rate;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}
}
