package com.orders.dto;


import lombok.Data;

import java.time.LocalDate;
@Data
public class OrderDto {
    private Long oid;
    private LocalDate date;
    private String orderStatus;
    private String orderForm;
}
