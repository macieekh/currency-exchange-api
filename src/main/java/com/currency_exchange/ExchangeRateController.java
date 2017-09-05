package com.currency_exchange;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ExchangeRateController {
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@Autowired
	private CurrencyService currencyService;
	

	@RequestMapping("/er")
	public String er() {
		return "er";
	}
		   
	 @RequestMapping("/exchangeRates")
	 public List<ExchangeRate> greeting() {
		 return exchangeRateService.getAllRates();
	 }
		
	 @RequestMapping(method=RequestMethod.POST, value="/exchangeRates")
	 public void addExchangeRate(@RequestBody String requestJson) throws JsonProcessingException, IOException {
		 ObjectMapper objectMapper = new ObjectMapper();
		 JsonNode jsonNode = objectMapper.readTree(requestJson);
		 Currency currencyFrom = currencyService.getCurrencyByCode(jsonNode.get("currencyFrom").asText().toUpperCase());
		 Currency currencyTo = currencyService.getCurrencyByCode(jsonNode.get("currencyTo").asText().toUpperCase());
		 double rate = Double.parseDouble(jsonNode.get("rate").toString());
		 ExchangeRate exchangeRate = new ExchangeRate(currencyFrom, currencyTo, rate);		 
		 exchangeRateService.addExchangeRate(exchangeRate);
	 }
	 
}
