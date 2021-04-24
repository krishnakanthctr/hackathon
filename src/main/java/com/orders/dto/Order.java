package com.orders.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Order {

	@Id
	private int oid;
	
	private LocalDate date;
	
	private int customerId ;
	
	private String orderStatus;
	
	private String orderForm;
}
