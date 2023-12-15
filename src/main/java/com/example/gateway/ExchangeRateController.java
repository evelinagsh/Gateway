package com.example.gateway;

import java.util.Optional;

//ExchangeRateController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json_api")
public class ExchangeRateController {

 @Autowired
 private ExchangeRateRepository exchangeRateRepository;

 @PostMapping("/current")
 public ResponseEntity<Object> getCurrentExchangeRate(@RequestBody ExchangeRateRequest request) {
     if (isDuplicateRequest(request.getRequestId())) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
             .body("Duplicate request with ID: " + request.getRequestId());
     }

     Optional<ExchangeRate>  currencyData = exchangeRateRepository.findTopByCurrencyOrderByDateDesc(request.getCurrency());

     if (currencyData.isPresent()) {
         ExchangeRate exchangeRate = currencyData.get();
         ExchangeRateResponse response = new ExchangeRateResponse();
         response.setExchangeRateData(exchangeRate.getRate());
         return ResponseEntity.ok(response);
     } else {
    	 return ResponseEntity.ok(null);
     }

 }

 // Implement a method to check for duplicate requests
 private boolean isDuplicateRequest(long requestId) {
     return false;
 }
}
