package com.devsuperior.hrworker.service;

import com.devsuperior.hrworker.entity.Worker;
import com.devsuperior.hrworker.exception.WorkerNotFoundException;
import com.devsuperior.hrworker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {
	private final WorkerRepository repository;

	public Worker save(final Worker worker){
		return repository.save(worker);
	}

	public void delete(final Long id){
		final Worker worker = findById(id);
		repository.deleteById(worker.getId());
	}

	public Worker findById(Long id){
		final Optional<Worker> opWorker = repository.findById(id);
		
		if(opWorker.isPresent()) {
			return opWorker.get();
		}
		
		throw new WorkerNotFoundException("Trabalhador não encontrado");
	}
	
	public List<Worker> findAll(){
		return repository.findAll();
	}
}