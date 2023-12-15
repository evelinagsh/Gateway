package com.example.gateway;

import java.util.Date;

public class ExchangeRateHistoryRequest {

    private long requestId;
    private long timestamp;
    private String client;
    private String currency;
    private int period;

    // Constructors, getters, and setters

    // Assuming a method to calculate the start date based on the specified period
    public Date calculateStartDate() {
        // Subtract the specified number of hours from the request timestamp
        Date startDate = new Date(this.timestamp - period * 3600 * 1000);
        return startDate;
    }
    
    public long getRequestId() {
		return this.requestId;
	}

	public String getCurrency() {		
		return this.currency;
	}

	public int getPeriod() {
		return this.period;
	}
	
	public long getTimestamp() {
		return this.timestamp;
	}
}
