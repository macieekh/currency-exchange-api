package com.currency_exchange;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
	public Currency findByCurrencyCode(String currencyFrom);

}



