package org.OrderService.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class OrderTopic {

	@Bean
	public NewTopic orderserviceTopic() {
		
		return TopicBuilder.name("orders-service").build();
	}
	
	@Bean
	public NewTopic orderfulfillmentTopic() {
		return TopicBuilder.name("orders-completed").build();
	}
	
}
