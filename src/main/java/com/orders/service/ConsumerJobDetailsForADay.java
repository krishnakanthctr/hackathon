package com.orders.service;

import java.util.List;

import com.orders.dto.BatchJobExecution;

public interface ConsumerJobDetailsForADay {

	public List<BatchJobExecution> ConsumerJobDetailsForOneDay(String date);
}
