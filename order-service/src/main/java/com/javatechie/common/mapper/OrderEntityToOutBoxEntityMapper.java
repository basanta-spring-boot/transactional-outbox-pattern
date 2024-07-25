package com.javatechie.common.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.entity.Order;
import com.javatechie.entity.OutboxMessage;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class OrderEntityToOutBoxEntityMapper {


    @SneakyThrows
    public OutboxMessage map(Order order) {
        return
                OutboxMessage.builder()
                        .aggregateId(order.getId().toString())
                        .payload(new ObjectMapper().writeValueAsString(order))
                        .createdAt(new Date())
                        .processed(false)
                        .build();
    }
}
