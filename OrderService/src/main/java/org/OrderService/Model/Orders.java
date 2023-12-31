package org.OrderService.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {
	@Id 
	private UUID  orderID = UUID.randomUUID();;
	private String emailId;
	private String productName;
	private int totalcost;
	private String userId;
	private String orderStatus;
	private UUID txnId = UUID.randomUUID();
	
	static int count = 0;
	
	
	
	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public UUID getTxnId() {
		return txnId;
	}

	

	public UUID getOrderId() {
		return orderID;
	}
	


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return this.txnId+" "+ this.orderID +" "+this.userId+" "+this.emailId+" "+this.productName+" "+this.orderStatus;
	}
	
	
	
	
	
	

}
