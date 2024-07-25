package com.javatechie.entity;

import com.javatechie.common.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ORDER_TBLS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String customerId;
    private String productType;
    private int quantity;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Date orderDate;
}
