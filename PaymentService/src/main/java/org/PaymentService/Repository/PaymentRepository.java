package org.PaymentService.Repository;

import java.util.UUID;

import org.PaymentService.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

	
	public Payment findByuserId(String id);
	
	
	
	
	
}
