package com.orders.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobCriteria {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String format;

}
