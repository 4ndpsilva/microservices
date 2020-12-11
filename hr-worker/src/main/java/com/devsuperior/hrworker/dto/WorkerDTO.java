package com.devsuperior.hrworker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerDTO extends BaseDTO {
    private String name;
    private Double dailyIncome;
}