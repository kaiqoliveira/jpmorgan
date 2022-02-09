package br.com.api.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trade")
public class Trade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
	@Column(name="tradetime")
	private LocalDate timeStamp = LocalDate.now();
	
	@Column(name="quantity")
	private int quantity;
	
	
	@Column(name="price")
	private Double price;
	
	////Ou OneToOne??
	@ManyToOne
	@JoinColumn(name="orderid")
	private OrderT orderid;
	
	public OrderT getOrderid() {
		return orderid;
	}

	public void setOrderid(OrderT orderid) {
		this.orderid = orderid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
        return id;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = Double.valueOf(price);
	}

	public Trade(LocalDate timeStamp, int quantity, Double price) {
	
		this.timeStamp = timeStamp;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Trade() {}
	
	
	

}
