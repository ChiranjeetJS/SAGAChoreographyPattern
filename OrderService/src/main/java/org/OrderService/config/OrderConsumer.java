package org.OrderService.config;

import org.OrderService.Model.Payment;
import org.OrderService.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		
	Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
	
	logger.info(payment.toString());
	
		service.ProcessOrder(payment);
		
		
	}
	
	
	

}
