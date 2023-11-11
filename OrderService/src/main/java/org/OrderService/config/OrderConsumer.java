package org.OrderService.config;

import org.OrderService.Model.Payment;
import org.OrderService.Service.OrderService;
import org.BaseDomain.Model.PaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
	@Autowired
	OrderService service;
	
	@KafkaListener(topics = "payment-service",groupId = "myGroup")
	public void consumePaymentDetails(PaymentEvent payment) {
		
		System.out.println(payment);
		service.ProcessOrder(payment);
		
		
	}
	
	
	

}
