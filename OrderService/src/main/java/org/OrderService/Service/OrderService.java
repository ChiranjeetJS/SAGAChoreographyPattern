package org.OrderService.Service;

import java.util.List;
import java.util.UUID;

import org.BaseDomain.Model.OrderEvent;
import org.BaseDomain.Model.PaymentEvent;
import org.OrderService.Model.Orders;
import org.OrderService.Repository.OrderRepo;
import org.OrderService.config.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	
	@Autowired
	OrderRepo repo;
	@Autowired
	OrderProducer producer;
	
	public Orders addOrder(Orders order) {
		
		order.setOrderStatus("Pending");
		repo.save(order);
		
		OrderEvent event = new OrderEvent();
		
		event.setOrderStatus("Pending");
		event.setProductName(order.getProductName());
		event.setTotalcost(order.getTotalcost());
		event.setUserId(order.getUserId());
		
		producer.sendMessage(event);
		
		return order;
	}
	
	public Orders ProcessOrder(PaymentEvent payment) {
		
		Orders order = repo.findByuserId(payment.getUserId());
		
		if(payment.getPaymentStatus().equals("Success")) {
			order.setOrderStatus("Success");
		}
		else {
			order.setOrderStatus("Failure");
		}
		
		repo.save(order);
		
		return  order;
		
	}
	
	
	public Orders findByOrderId(UUID orderId) {
		
	    return repo.findById(orderId).get();
	}
	
	public List<Orders> getOrders(){
		
		return repo.findAll();
		
	}

}
