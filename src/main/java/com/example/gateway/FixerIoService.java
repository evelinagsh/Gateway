package com.example.gateway;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class FixerIoService {

	private static final String FIXER_IO_API_URL = "http://data.fixer.io/api/latest?access_key=";
	
	@Value("${fixer-io-api-key}")
	private String FIXER_IO_API_KEY;

	private RestTemplate restTemplate;

	public FixerIoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public FixerIoResponse getLatestRates() {
		return restTemplate.getForObject(FIXER_IO_API_URL + this.FIXER_IO_API_KEY, FixerIoResponse.class);
	}
}
