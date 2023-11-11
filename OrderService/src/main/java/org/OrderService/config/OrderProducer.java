package org.OrderService.config;

import org.BaseDomain.Model.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
	
	KafkaTemplate<String, OrderEvent> kafkatemplate;
	
	
	public OrderProducer(KafkaTemplate<String, OrderEvent> kafkatemplate) {
	    
		this.kafkatemplate = kafkatemplate;
	}


	public void sendMessage(OrderEvent order) {
		
		Message<OrderEvent> msg = MessageBuilder.withPayload(order).setHeader(KafkaHeaders.TOPIC,"orders-service").build();
		System.out.println(order);
		kafkatemplate.send(msg);
		
	}
	
	public void sendMessageafterCompletion(OrderEvent order) {
		
		Message<OrderEvent> msg = MessageBuilder.withPayload(order).setHeader(KafkaHeaders.TOPIC,"orders-completed").build();
		System.out.println(order);
		kafkatemplate.send(msg);
		
	}

}
