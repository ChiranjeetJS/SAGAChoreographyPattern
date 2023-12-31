package org.BaseDomain.Model;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class PaymentEvent {
	
	@Override
	public String toString() {
		return "transactionId = "+txnID+ ", paymentId=" + paymentId + ", userId=" + userId + ", balance=" + balance + ", paymentStatus="
				+ paymentStatus;
	}
	
	private UUID paymentId = UUID.randomUUID();
	private String userId;
	private int balance;
	private String paymentStatus;
    private UUID txnID;
    
	public UUID getTxnID() {
		return txnID;
	}

	public void setTxnID(UUID txnID) {
		this.txnID = txnID;
	}

	public UUID getPaymentId() {
		return paymentId;
	}

	public int getBalance() {
		return balance;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	
	
	
	
	

}

