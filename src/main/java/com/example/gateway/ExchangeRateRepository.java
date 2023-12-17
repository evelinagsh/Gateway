package com.example.gateway;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findTopByCurrencyOrderByDateDesc(String currency);

	List<ExchangeRate> findByDateAfterAndCurrency(Date date, String currency);
}
