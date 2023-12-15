package com.example.gateway;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findTopByCurrencyOrderByDateDesc(String currency);

}
