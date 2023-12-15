package com.example.gateway;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private BigDecimal rate;
    private LocalDate date;
    
    protected ExchangeRate() {}
    
	public ExchangeRate(String currency, LocalDate date, BigDecimal rate) {
		this.currency = currency;
		this.date = date;
		this.rate = rate;
	} 

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
		
	}
	
	@Override
	public String toString() {
		return this.currency + this.rate;
	}
}