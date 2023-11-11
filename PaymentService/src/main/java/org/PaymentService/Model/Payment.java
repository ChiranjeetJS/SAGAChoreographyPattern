package org.PaymentService.Model;

import java.util.UUID;

import org.apache.kafka.common.Uuid;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Payment {
	
	@Override
	public String toString() {
		return "transactionID = "+txnId+ ", paymentId=" + paymentId + ", userId=" + userId + ", balance=" + balance + ", paymentStatus="
				+ paymentStatus;
	}
	
	private String generateTxnID(){
		
		
		
		String id = "txn000"+count;
		count++;
		return id;
	}
	
	static int count = 100;
	@Id
	private UUID paymentId = UUID.randomUUID();
	private String userId;
	private int balance;
	private String paymentStatus;
	private UUID txnId;
	
	public UUID getPaymentId() {
		return paymentId;
	}

	public UUID getTxnId() {
		return txnId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}

	
	public void setTxnId(UUID txnId) {
		this.txnId = txnId;
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
