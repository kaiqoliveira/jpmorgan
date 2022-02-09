package br.com.api.restapi.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReturnJson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String tradercode;
	private BigDecimal total;

	public String getTradercode() {
		return tradercode;
	}
	public void setTradercode(String tradercode) {
		this.tradercode = tradercode;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
