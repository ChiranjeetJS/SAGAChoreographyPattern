package org.PaymentService.service;

import java.util.List;
import java.util.UUID;

import org.BaseDomain.Model.OrderEvent;
import org.BaseDomain.Model.PaymentEvent;
import org.PaymentService.Config.PaymentProducer;
import org.PaymentService.Model.Payment;
import org.PaymentService.Repository.PaymentRepository;
import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentrepo;
	
	@Autowired
	PaymentProducer producer;
	
	public String addPayment(Payment payment) {
		
		paymentrepo.save(payment);
		
		
		
		return "Payment Details added successfully";
		
	}
	
	public Payment findByuserId(UUID id) {
		
		return paymentrepo.findById(id).get();
	}
	
	
	public Payment updateBalance(OrderEvent order) {
		

		Payment p = paymentrepo.findByuserId(order.getUserId());
		
		
		
	     int balance = p.getBalance()-order.getTotalcost();
	    
	    if(balance >= 0) {
	    p.setBalance(balance);
	    p.setPaymentStatus("Success");
	    
	    order.setOrderStatus("Succcess");
	    }
	    else {
	    	p.setBalance(p.getBalance());
	    	p.setPaymentStatus("Failure");
	    	
	    }
	    p.setTxnId(order.getTxnID());
	    
	    PaymentEvent event = new PaymentEvent();
	    
	    event.setPaymentStatus(p.getPaymentStatus());
	    event.setBalance(p.getBalance());
	    event.setUserId(p.getUserId());
	    event.setTxnID(p.getTxnId());
	    
	    
	    producer.sendPaymentInfo(event);
	    
	    paymentrepo.save(p);
	    
	    return p;
	}
	
	
	
	
	public List<Payment> getPaymentDetails(){
		
		return paymentrepo.findAll();
	}
	
	public Payment updatePayment(Payment pay) {
		
		 Payment updatedpayment = paymentrepo.findByuserId(pay.getUserId());
		 
		 updatedpayment.setBalance(updatedpayment.getBalance()+pay.getBalance());;
		 
		 paymentrepo.save(updatedpayment);
		 
		 return updatedpayment;
	}

			
	
}
