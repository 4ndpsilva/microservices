package com.devsuperior.hrworker.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entity.Worker;
import com.devsuperior.hrworker.service.WorkerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/workers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerResource {
	private final WorkerService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
}