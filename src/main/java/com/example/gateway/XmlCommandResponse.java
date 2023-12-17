package com.example.gateway;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class XmlCommandResponse {

    private String message;
    private String rate;
    private Date date;
    private List<ExchangeRate> currencyHistory;

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @XmlElement
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlElement
    public List<ExchangeRate> getCurrencyHistory() {
        return currencyHistory;
    }

    public void setCurrencyHistory(List<ExchangeRate> currencyHistory) {
        this.currencyHistory = currencyHistory;
    }
}
