package com.devsuperior.hrworker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.entity.Worker;
import com.devsuperior.hrworker.repository.WorkerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerService {
	private final WorkerRepository repository;
	
	public Worker findById(Long id){
		Optional<Worker> opWorker = repository.findById(id);
		
		if(opWorker.isPresent()) {
			return opWorker.get();
		}
		
		throw new RuntimeException("Trabalhador não encontrado");
	}
	
	public List<Worker> findAll(){
		return repository.findAll();
	}
}