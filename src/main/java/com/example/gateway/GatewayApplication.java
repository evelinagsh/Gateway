package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

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
			
			//			ratesCollector.collectRates();
			
//			// save a few ExchangeRates
//			repository.save(new ExchangeRate("Jack", LocalDate.now(), new BigDecimal(0.03125)));
//
//
//			// fetch all ExchangeRates
//			log.info("ExchangeRates found with findAll():");
//			log.info("-------------------------------");
//			repository.findAll().forEach(ExchangeRate -> {
//				log.info(ExchangeRate.toString());
//			});
//			log.info("");
//
//			// fetch an individual ExchangeRate by ID
//			ExchangeRate ExchangeRate = repository.findById(1L);
//			log.info("ExchangeRate found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(ExchangeRate.toString());
//			log.info("");
//
//			// fetch ExchangeRates by last name
//			log.info("ExchangeRate found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			log.info("");
		};
	}
}
