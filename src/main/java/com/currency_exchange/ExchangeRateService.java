package com.currency_exchange;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	public List<ExchangeRate> getAllRates() {
		List<ExchangeRate> exchangeRates = new ArrayList<>();
		exchangeRateRepository.findAll().forEach(exchangeRates::add);
		return exchangeRates;
	}
	
	public void addExchangeRate(ExchangeRate exchangeRate) {
		exchangeRateRepository.save(exchangeRate);
	}
}
