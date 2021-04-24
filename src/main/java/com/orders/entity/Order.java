package com.orders.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Order {

	@Id
	private Long oid;
	
	private LocalDate date;
	
	private int customerId ;
	
	private String orderStatus;
	
	private String orderForm;
}
