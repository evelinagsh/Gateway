package com.example.gateway;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class ExchangeRateRequest {
   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestId;
    private long timestamp;
    private String client;
    private String currency;
	
    
    public long getRequestId() {
    	
		return this.requestId;
	}


	public String getCurrency() {
		
		return this.currency;
	}

   
}


