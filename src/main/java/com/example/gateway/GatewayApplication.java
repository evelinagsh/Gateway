package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@EnableScheduling
public class GatewayApplication {

	private static final Logger log = LoggerFactory.getLogger(GatewayApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Bean
	public CommandLineRunner demo(ExchangeRateRepository repository, RatesCollector ratesCollector ) {
		return (args) -> {
			//Prepare the initial data base
			Iterable<ExchangeRate> iterable = repository.findAll();

	        Iterator<ExchangeRate> iterator = iterable.iterator();
	        boolean isEmpty = !iterator.hasNext();

	        if (isEmpty) {
	        	ratesCollector.collectRates();
	            System.out.println("Rates collected");
	        }

			
		};
	}
}
