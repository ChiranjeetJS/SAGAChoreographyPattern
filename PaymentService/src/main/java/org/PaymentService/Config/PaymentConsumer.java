package org.PaymentService.Config;

import java.util.ArrayList;
import java.util.List;

import org.BaseDomain.Model.OrderEvent;
import org.PaymentService.Model.Order;
import org.PaymentService.Model.Payment;
import org.PaymentService.Repository.PaymentRepository;
import org.PaymentService.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

	@Autowired
	PaymentService service;
	@Autowired
	PaymentProducer producer;
	
	Logger logs = LoggerFactory.getLogger(PaymentConsumer.class);
	 static List<OrderEvent> list = new ArrayList<OrderEvent>();
	
	
	@KafkaListener(topics = "orders-service", groupId = "myGroup")
	public void consumeOrder(OrderEvent order) {
		
		
	      list.add(order);
	//    producer.sendPaymentInfo(payment);
	    
	    
		service.updateBalance(order);
		
	    logs.info(order.toString());
	    
	    	
	}
	
	public List<OrderEvent> getorderDetails(){
		return list;
	}
	
	
	public OrderEvent processOrder(OrderEvent order) {
		
		return order;
		
	}
}

