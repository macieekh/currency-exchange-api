package com.currency_exchange;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyContoller {
	
	@Autowired
	private CurrencyService currencyService;


	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
		   

	 @RequestMapping("/currency")
	 public List<Currency> greeting() {
		 return currencyService.getAllCurrencies();
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, value="/currency")
	 public void addCurrency(@RequestBody Currency currency) {
		 currencyService.addCurrency(currency);
	 }
	 
	 @RequestMapping(method=RequestMethod.GET, value="/currency/{id}")
	 public Currency getCurrencyById(@PathVariable long id) {
		 return currencyService.getCurrencyById(id);
	 }

}