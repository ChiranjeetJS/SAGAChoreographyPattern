package org.OrderService.config;

import org.OrderService.Model.Payment;
import org.BaseDomain.Model.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
	
	@KafkaListener(topics = "payment-topic",groupId = "myGroup")
	public void consumePaymentDetails(PaymentEvent payment) {
		
		
		
	}
	

}
