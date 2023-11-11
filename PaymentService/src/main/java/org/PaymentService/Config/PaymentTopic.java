package org.PaymentService.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class PaymentTopic {
	
	@Bean
	public NewTopic paymentserviceTopic() {
		
		return TopicBuilder.name("payment-service").build();
	}

}
