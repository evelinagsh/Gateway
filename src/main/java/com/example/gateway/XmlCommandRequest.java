package com.example.gateway;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class XmlCommandRequest {

    private String id;
    private String consumer;
    private String currency;
    private String period;

    @XmlElement
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "get")
    public String getConsumer() {
        return this.consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @XmlElement
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlElement
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Date calculateStartDate() {
        Long period = Long.parseLong(this.period);
        // TODO - calculate start date aware of timezones
        Date startDate = new Date(new Timestamp(System.currentTimeMillis() - period * 3600 * 1000).getTime());

        return startDate;
    }
}