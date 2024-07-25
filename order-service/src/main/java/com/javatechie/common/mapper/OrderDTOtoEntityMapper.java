package com.javatechie.common.mapper;

import com.javatechie.common.dto.OrderRequestDTO;
import com.javatechie.common.enums.OrderStatus;
import com.javatechie.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class OrderDTOtoEntityMapper {

    public Order map(OrderRequestDTO orderRequestDTO) {
        return
                Order.builder()
                        .customerId(orderRequestDTO.getCustomerId())
                        .name(orderRequestDTO.getName())
                        .productType(orderRequestDTO.getProductType())
                        .quantity(orderRequestDTO.getQuantity())
                        .price(orderRequestDTO.getPrice())
                        .orderDate(new Date())
                        .status(OrderStatus.CREATED)
                        .build();

    }
}
