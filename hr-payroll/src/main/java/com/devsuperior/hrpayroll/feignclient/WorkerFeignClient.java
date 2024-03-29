package com.devsuperior.hrpayroll.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.hrpayroll.entity.Worker;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/api/v1/workers")
public interface WorkerFeignClient {
	@GetMapping("/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}