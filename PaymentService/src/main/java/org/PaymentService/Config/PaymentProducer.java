package org.PaymentService.Config;



import org.BaseDomain.Model.PaymentEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {
	
	KafkaTemplate<String, PaymentEvent> kafkatemplate;

	public PaymentProducer(KafkaTemplate<String, PaymentEvent> kafkatemplate) {
		
		this.kafkatemplate = kafkatemplate;
	}
	
	
	public void sendPaymentInfo(PaymentEvent p) {
		
		Message<PaymentEvent>  message = MessageBuilder.withPayload(p).setHeader(KafkaHeaders.TOPIC,"payment-service").build();
		
		kafkatemplate.send(message);
	}
	
	
	
	
	
	
	

}
