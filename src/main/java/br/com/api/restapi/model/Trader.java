package br.com.api.restapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trader")
public class Trader implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tradercode")
	private String code;
	
	@Column(name="tradername")
	private String name;
	
	
	
	
	public String getTraderCode() {
		return code;
	}
	public void setTraderCode(String traderCode) {
		this.code = traderCode;
	}
	public String getTraderName() {
		return name;
	}
	public void setTraderName(String traderName) {
		this.name = traderName;
	}
	
	public Trader(String traderCode, String traderName) {
		
		this.code = traderCode;
		this.name = traderName;
	}
	
	public Trader() {}
	
	
	
}
