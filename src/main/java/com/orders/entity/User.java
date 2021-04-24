package com.orders.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table (name = "squad2User")
public class User {

	@Id
	private Long id;
	
	private String userName;
	
	private String password;
}
