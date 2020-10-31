package com.devsuperior.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entity.Payment;
import com.devsuperior.hrpayroll.entity.Worker;
import com.devsuperior.hrpayroll.feignclient.WorkerFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentService {
	private final WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}