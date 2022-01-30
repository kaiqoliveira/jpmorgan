package br.com.api.restapi;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trade")
public class Trade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long tradeid;

	
	@Column(name="timestamp")
	private LocalDate timeStamp = LocalDate.now();
	
	@Column(name="qty")
	private int quantity;
	
	
	@Column(name="price")
	private double price;
	
	public Long getId() {
        return tradeid;
    }

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Trade(LocalDate timeStamp, int quantity, double price) {
		super();
		this.timeStamp = timeStamp;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Trade() {}
	
	
	

}
