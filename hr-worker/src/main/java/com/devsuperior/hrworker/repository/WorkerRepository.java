package com.devsuperior.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{}