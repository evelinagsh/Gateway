package com.example.gateway;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public ResponseEntity<Object> handleCurrentExchangeRateRequest(ExchangeRateRequest request) {
        if (isDuplicateRequest(request.getRequestId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate request with ID: " + request.getRequestId());
        }

        Optional<ExchangeRate> currencyData = getCurrentExchangeRate(request.getCurrency());

        if (currencyData.isPresent()) {
            ExchangeRate exchangeRate = currencyData.get();
            ExchangeRateResponse response = new ExchangeRateResponse();
            response.setRate(exchangeRate.getRate());
            response.setDate(exchangeRate.getDate());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    public ResponseEntity<Object> handleCurrencyHistoryRequest(ExchangeRateHistoryRequest request) {
        if (isDuplicateRequest(request.getRequestId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate request with ID: " + request.getRequestId());
        }

        List<ExchangeRate> currencyHistory = getCurrencyHistory(request.getCurrency(), request.calculateStartDate());

        if (!currencyHistory.isEmpty()) {
            ExchangeRateHistoryResponse response = new ExchangeRateHistoryResponse();
            response.setCurrencyHistory(currencyHistory);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    public ResponseEntity<XmlCommandResponse> handleXmlCommandRequest(XmlCommandRequest request) {
        // Check for duplicate request based on the id attribute
        if (isDuplicateRequest(Long.parseLong(request.getId()))) {
            XmlCommandResponse response = new XmlCommandResponse();
            response.setMessage("Duplicate request with ID: " + request.getId() + " received");
            return ResponseEntity.ok(response);
        }

        // Check if the history element is present
        if (request.getPeriod() != null) {
            // Case 2: History is provided
            return handlePeriodStatistics(request);
        } else {
            // Case 1: History is not provided
            return handleCurrentData(request);
        }
    }

    private ResponseEntity<XmlCommandResponse> handlePeriodStatistics(XmlCommandRequest request) {
        List<ExchangeRate> currencyHistory = getCurrencyHistory(request.getCurrency(), request.calculateStartDate());

        if (!currencyHistory.isEmpty()) {
            XmlCommandResponse response = new XmlCommandResponse();
            response.setCurrencyHistory(currencyHistory);
            return ResponseEntity.ok(response);
        } else {
            XmlCommandResponse response = new XmlCommandResponse();
            response.setMessage("No data found for currency: " + request.getCurrency());
            return ResponseEntity.ok(response);
        }
    }

    private ResponseEntity<XmlCommandResponse> handleCurrentData(XmlCommandRequest request) {
        Optional<ExchangeRate> currencyData = getCurrentExchangeRate(request.getCurrency());

        if (currencyData.isPresent()) {
            ExchangeRate exchangeRate = currencyData.get();
            XmlCommandResponse response = new XmlCommandResponse();
            response.setDate(exchangeRate.getDate());
            response.setRate(exchangeRate.getRate().toString());
            return ResponseEntity.ok(response);
        } else {
            XmlCommandResponse response = new XmlCommandResponse();
            response.setMessage("No data found for currency: " + request.getCurrency());
            return ResponseEntity.ok(response);
        }
    }

    private Optional<ExchangeRate> getCurrentExchangeRate(String currency) {
        Optional<ExchangeRate> currencyData = exchangeRateRepository.findTopByCurrencyOrderByDateDesc(currency);
        return currencyData;
    }

    private List<ExchangeRate> getCurrencyHistory(String currency, Date startDate) {
        List<ExchangeRate> currencyHistory = exchangeRateRepository.findByDateAfterAndCurrency(startDate, currency);
        return currencyHistory;
    }

    private boolean isDuplicateRequest(long requestId) {
        // TODO implement when the request are stored in the database
        return false;
    }


}
