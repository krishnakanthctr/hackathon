package com.orders.serviceImpl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.dto.BatchJobExecution;
import com.orders.repostitoy.BatchJobExecutionRepo;
import com.orders.service.ConsumerJobDetailsForADay;

@Service
public class ConsumerJobDetailsForOneDayImpl implements ConsumerJobDetailsForADay {

	@Autowired
	private BatchJobExecutionRepo batchJobExecutionRepo;

	@Override
	public List<BatchJobExecution> ConsumerJobDetailsForOneDay(String date) {
		List<BatchJobExecution> details = new ArrayList<BatchJobExecution>();
		try {
			BatchJobExecution job=new BatchJobExecution();
	    	LocalDate  localDate= LocalDate.parse(date);
			details = batchJobExecutionRepo.findByCreateTimeContaining(localDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

}
