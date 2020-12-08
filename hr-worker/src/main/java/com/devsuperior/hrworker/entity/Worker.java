package com.devsuperior.hrworker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_WORKER")
public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID")
	@SequenceGenerator(name = "SEQ_ID", allocationSize = 1, sequenceName = "WORKER_SEQ")
	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private Double dailyIncome;
}