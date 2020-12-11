package com.devsuperior.hrworker.resource;

import com.devsuperior.hrworker.dto.WorkerDTO;
import com.devsuperior.hrworker.entity.Worker;
import com.devsuperior.hrworker.mapper.WorkerMapper;
import com.devsuperior.hrworker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workers")
@RequiredArgsConstructor
public class WorkerResource {
	private final WorkerService service;
	private final WorkerMapper mapper;

	@PostMapping
	public ResponseEntity<WorkerDTO> save(@RequestBody WorkerDTO dto){
		final Worker worker = mapper.toEntity(dto);
		dto = mapper.toDTO(service.save(worker));
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
		final WorkerDTO dto = mapper.toDTO(service.findById(id));
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll(){
		final List<WorkerDTO> listDTO = mapper.toListDTO(service.findAll());
		return ResponseEntity.ok(listDTO);
	}
}