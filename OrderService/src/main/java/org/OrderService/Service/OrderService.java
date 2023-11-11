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
		event.setTxnID(order.getTxnId());
		
		producer.sendMessage(event);
		
		return order;
	}
	
	public Orders ProcessOrder(PaymentEvent payment) {
		
		Orders order = repo.findBytxnId(payment.getTxnID());
		
		System.out.println(order);
		
		if(payment.getPaymentStatus().equals("Success")) {
			order.setOrderStatus("Success");
		}
		else {
			order.setOrderStatus("Failure");
			
		}
		
		OrderEvent event = new OrderEvent();
		
		event.setOrderStatus(order.getOrderStatus());
		event.setProductName(order.getProductName());
		event.setTotalcost(order.getTotalcost());
		event.setUserId(order.getUserId());
		event.setTxnID(order.getTxnId());
		
		producer.sendMessageafterCompletion(event);
		
		
		repo.save(order);
		
		System.out.println(order);
		
		
		
		return  order;
		
	}
	
	
	public Orders findByOrderId(UUID orderId) {
		
	    return repo.findById(orderId).get();
	}
	
	public List<Orders> getOrders(){
		
		return repo.findAll();
		
	}

}
