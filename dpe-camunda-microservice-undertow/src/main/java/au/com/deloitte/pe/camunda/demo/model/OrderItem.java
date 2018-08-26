package au.com.deloitte.pe.camunda.demo.model;

import java.io.Serializable;

public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String orderId;
	private int amount;

	public OrderItem() {}
	
	public OrderItem(String orderId, int amount) {
		this.orderId = orderId;
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
