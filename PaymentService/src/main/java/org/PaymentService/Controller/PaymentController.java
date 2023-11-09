package org.PaymentService.Controller;

import java.util.List;
import java.util.UUID;

import org.BaseDomain.Model.OrderEvent;
import org.PaymentService.Config.PaymentConsumer;
import org.PaymentService.Config.PaymentProducer;
import org.PaymentService.Model.Order;
import org.PaymentService.Model.Payment;
import org.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {
	
	@Autowired
	PaymentService service;
	@Autowired
	PaymentProducer producer;
	@Autowired
	PaymentConsumer consumer;
	
	@PostMapping("/addPayment")
	public Payment addPayment(@RequestBody Payment payment) {
		
		
	
		  //service.addPayment(payment);
		 // payment.setPaymentStatus("Success");
		  
		  return payment;
		  
		  
		
		}
	@GetMapping("/getUser/{userId}")
	public Payment findUser(@PathVariable UUID userId) {
		
		return service.findByuserId(userId);
	}
	
	@GetMapping("/paymentDetails")
	public List<Payment> getPaymentDetails(){
		
		return  service.getPaymentDetails();
	}
	
		 
		 
	
	@GetMapping("/orderDetails")
	public List<OrderEvent> getOrderDetails()
	{
		return consumer.getorderDetails();
	
	}
	
	
		 
		
		
	

}
