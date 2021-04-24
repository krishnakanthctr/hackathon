package com.orders.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "squad2User")
public class User {

	@Id
	private int id;
	
	private String userName;
	
	private String password;
}
