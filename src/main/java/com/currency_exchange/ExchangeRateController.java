package com.currency_exchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@Autowired
	private CurrencyService currencyService;
	

	@RequestMapping("/er")
	public String dupa() {
		return "er";
	}
		   
	 @RequestMapping("/exchangeRates")
	 public List<ExchangeRate> greeting() {
		 return exchangeRateService.getAllRates();
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, value="/exchangeRates/{currencyFrom}/{currencyTo}")
	 public void addExchangeRate(@RequestBody ExchangeRate exchangeRate, @PathVariable String currencyFrom, @PathVariable String currencyTo) {
		 Currency currencyFrom1 = currencyService.getCurrencyByCode(currencyFrom.toUpperCase());
		 Currency currencyTo1 = currencyService.getCurrencyByCode(currencyTo.toUpperCase());
		 exchangeRate.setCurrencyFrom(currencyFrom1);
		 exchangeRate.setCurrencyTo(currencyTo1);
		 
		 exchangeRateService.addExchangeRate(exchangeRate);
	 }
}
