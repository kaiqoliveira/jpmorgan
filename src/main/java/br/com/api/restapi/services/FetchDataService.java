package br.com.api.restapi.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.restapi.model.Trade;
import br.com.api.restapi.model.dto.ReturnJson;
import br.com.api.restapi.repository.FetchDataRepository;


@Service
public class FetchDataService  {

	@Autowired
	private FetchDataRepository repo;
	
	public List<Trade> findAllTrades(){
		
		return repo.findAll();
	}
	
	public List<ReturnJson> getTotal() {
		List<Trade> trades = repo.findAll();
		List<ReturnJson> response = new ArrayList<>();
		
		for(Trade trade : trades) {
			ReturnJson ret = new ReturnJson();
			ret.setTradercode(trade.getOrderid().getTrader().getTraderCode());
			ret.setTotal(calculateTotal(trade.getQuantity(), BigDecimal.valueOf(trade.getPrice())).setScale(3, RoundingMode.CEILING));
			response.add(ret);
		}
		
		return response;
	}
	
	private BigDecimal calculateTotal(int qtty, BigDecimal price) {
		BigDecimal total = new BigDecimal("0");
		if( qtty != 0 && !price.equals(0)) {
			total = price.multiply(BigDecimal.valueOf(qtty));
		}
		return total;
	}
	
	

}
	
