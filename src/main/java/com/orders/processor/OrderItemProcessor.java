package com.orders.processor;

import com.orders.dto.OrderDto;
import org.springframework.batch.item.ItemProcessor;


public class OrderItemProcessor implements ItemProcessor<OrderDto, OrderDto> {

    @Override
    public OrderDto process(OrderDto order) throws Exception {
        return order;
    }
}
