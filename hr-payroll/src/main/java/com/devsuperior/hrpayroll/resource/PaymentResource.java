package com.devsuperior.hrpayroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entity.Payment;
import com.devsuperior.hrpayroll.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentResource {
	private final PaymentService service;
	
	@GetMapping("/worker/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable int days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
}