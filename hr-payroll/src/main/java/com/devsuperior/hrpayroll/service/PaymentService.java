package com.devsuperior.hrpayroll.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entity.Payment;
import com.devsuperior.hrpayroll.entity.Worker;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentService {
	private final RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	public Payment getPayment(Long workerId, int days) {
		Worker worker = restTemplate.getForObject(workerHost + "/api/v1/workers/{id}", Worker.class, Map.of("id", workerId.toString()));
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}