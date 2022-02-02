package br.com.api.restapi.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.restapi.model.Trade;
import br.com.api.restapi.model.Trader;
import br.com.api.restapi.model.dto.ReturnJson;
import br.com.api.restapi.repository.FetchDataRepository;


@Service
public class FetchDataService  {

	@Autowired
	private FetchDataRepository repo;
	
	
	public List<ReturnJson> findAll() {
		List<Trade> trades = repo.findAll();
		List<ReturnJson> response = new ArrayList<>();
		
		for(Trade trade : trades) {
			ReturnJson ret = new ReturnJson();
			ret.setTradercode(trade.getOrderid().getTrader().getTraderCode());
			ret.setTotal(calculateTotal(trade.getQuantity(), trade.getPrice()));
			response.add(ret);
		}
		
		return response;
	}
	
	private double calculateTotal(int qtty, double value) {
		double total = 0;
		if( qtty != 0 && value != 0) {
			total = qtty * value;
		}
		return total;
	}

}
	
