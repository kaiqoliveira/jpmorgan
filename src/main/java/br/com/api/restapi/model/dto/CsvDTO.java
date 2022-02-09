package br.com.api.restapi.model.dto;

import java.math.BigDecimal;

public class CsvDTO {

	  private String traderCode;
	    private String traderName;
	    private Integer orderId;
	    private String Ticker;
	    private Integer quantity;
	    private BigDecimal price;
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
		public Integer getOrderId() {
			return orderId;
		}
		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}
		public String getTicker() {
			return Ticker;
		}
		public void setTicker(String ticker) {
			Ticker = ticker;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public CsvDTO(String traderCode, String traderName, Integer orderId, String ticker, Integer quantity,
				BigDecimal price) {
			super();
			this.traderCode = traderCode;
			this.traderName = traderName;
			this.orderId = orderId;
			Ticker = ticker;
			this.quantity = quantity;
			this.price = price;
		}

	   public CsvDTO() {}
}
