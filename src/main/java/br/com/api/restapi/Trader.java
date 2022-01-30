package br.com.api.restapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trader")
public class Trader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traderid;
	
	@Column(name="tradercode")
	private String traderCode;
	@Column(name="tradername")
	private String traderName;
	
	
	public Long getId() {
        return traderid;
    }
	public String getTraderCode() {
		return traderCode;
	}
	public void setTraderCode(String traderCode) {
		this.traderCode = traderCode;
	}
	public String getTraderName() {
		return traderName;
	}
	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}
	
	public Trader(String traderCode, String traderName) {
		super();
		this.traderCode = traderCode;
		this.traderName = traderName;
	}
	
	public Trader() {}
	
	
	
	
}
