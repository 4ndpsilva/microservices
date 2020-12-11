package com.devsuperior.hrworker.mapper;

import com.devsuperior.hrworker.dto.WorkerDTO;
import com.devsuperior.hrworker.entity.Worker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkerMapper extends GenericMapper<WorkerDTO, Worker>{ }
