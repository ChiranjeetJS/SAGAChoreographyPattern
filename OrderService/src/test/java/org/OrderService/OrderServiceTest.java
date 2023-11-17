package org.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.UUID;

import org.OrderService.Controller.OrderController;
import org.OrderService.Model.Orders;
import org.OrderService.Repository.OrderRepo;
import org.OrderService.Service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	

	@MockBean
	OrderService service;
	
	
	
	
	OrderController controller;
	
	
	
	@BeforeEach
	public void setUp() {
		
		controller = new OrderController();
	
	}
	
	@Test
	public void testfindById() {
		
		Orders order = new Orders();
		
		order.setOrderStatus("pending");
		order.setTotalcost(10000);
		order.setUserId("user");
		
		UUID id = UUID.randomUUID();
		
		Mockito.when(service.findByOrderId(id)).thenReturn(order);
	    assertEquals(order,controller.findById(id));
		
		

         
	}
	
	

}
