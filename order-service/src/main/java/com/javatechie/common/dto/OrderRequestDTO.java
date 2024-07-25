package com.javatechie.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private String customerId;
    private String name;
    private String productType;
    private int quantity;
    private BigDecimal price;
}
