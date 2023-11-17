package org.BaseDomain.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class OrderEvent {
	
	private UUID  orderID = UUID.randomUUID();;
	private String productName;
	private int totalcost;
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	private String userId;
	public UUID getTxnID() {
		return txnID;
	}
	
	private String emailId;

	public void setTxnID(UUID txnID) {
		this.txnID = txnID;
	}

	private String orderStatus;
	private UUID txnID;
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
		return this.txnID+" "+ this.orderID +" "+this.userId+" "+this.emailId+" "+this.productName+" "+this.orderStatus;
	}
	
	

	
	
	
	
	
	

}

