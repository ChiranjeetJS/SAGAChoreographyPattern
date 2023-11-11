package org.OrderService.Repository;

import java.util.UUID;

import org.OrderService.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,UUID> {

	public Orders findByuserId(String id);
	
	public Orders findBytxnId(UUID id);
}


