package com.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@SpringBootApplication
public class ordersApplication {
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(ordersApplication.class, args);
	}
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
		dataSourceBuilder.url(environment.getRequiredProperty("spring.datasource.url"));
		dataSourceBuilder.username(environment.getRequiredProperty("spring.datasource.username"));
		dataSourceBuilder.password(environment.getRequiredProperty("spring.datasource.password"));
		return dataSourceBuilder.build();
	}



}
