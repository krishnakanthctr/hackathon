package com.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.dto.BatchJobExecution;
import com.orders.serviceImpl.ConsumerJobDetailsForOneDayImpl;

@RestController
@RequestMapping("/data-publisher")
public class ConsumersJobForAParticularDay {

	@Autowired
	private ConsumerJobDetailsForOneDayImpl ConsumerJobDetailsForADayImpl;

	@GetMapping("/JobDetials/{date}")
	public List<BatchJobExecution> submitJob(@PathVariable String date) {

		return ConsumerJobDetailsForADayImpl.ConsumerJobDetailsForOneDay(date);

	}

}
