package org.EmailService.Config;

import org.BaseDomain.Model.OrderEvent;
import org.EmailService.Service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

  @Autowired
   MailService service;
	
	@KafkaListener(topics = "orders-completed", groupId = "myGroup" )
	public void processOrder(OrderEvent order) {
		
		Logger logger = LoggerFactory.getLogger(EmailConsumer.class);
		
		logger.info(order.toString());
		
		service.processEmail(order);
	
		
	}
	
}
