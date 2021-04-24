package com.orders.repostitoy;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orders.dto.BatchJobExecution;

@Repository
public interface BatchJobExecutionRepo extends JpaRepository<BatchJobExecution, Long> {
	
	List<BatchJobExecution> findByCreateTimeContaining(LocalDate date);

}
