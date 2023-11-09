package org.OrderService.Controller;

import java.util.List;
import java.util.UUID;

import org.OrderService.Model.Orders;
import org.OrderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	OrderService service;
	
	@PostMapping("/saveOrder")
	public Orders saveOrder(@RequestBody Orders order) {
		
	   return service.addOrder(order);
	}
	
	@GetMapping("/listOrders")
	public List<Orders> getOrders(){
		
		return service.getOrders();
	}
	@GetMapping("/order/{orderId}")
	public Orders findById(@PathVariable UUID orderId) {
		
		return service.findByOrderId(orderId);
	}
}
