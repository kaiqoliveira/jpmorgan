package br.com.api.restapi.model.dto;

import java.io.Serializable;

public class ReturnJson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String tradercode;
	private double total;

	public String getTradercode() {
		return tradercode;
	}
	public void setTradercode(String tradercode) {
		this.tradercode = tradercode;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
