package com.javatechie.service;

import com.javatechie.common.dto.OrderRequestDTO;
import com.javatechie.common.mapper.OrderDTOtoEntityMapper;
import com.javatechie.common.mapper.OrderEntityToOutBoxEntityMapper;
import com.javatechie.entity.Order;
import com.javatechie.entity.OutboxMessage;
import com.javatechie.repository.OrderRepository;
import com.javatechie.repository.OutboxMessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDTOtoEntityMapper orderDTOtoEntityMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEntityToOutBoxEntityMapper outBoxEntityMapper;
    @Autowired
    private OutboxMessageRepository outboxMessageRepository;

    @Transactional
    public Order createOrder(OrderRequestDTO orderRequest) {

        Order order = orderDTOtoEntityMapper.map(orderRequest);
        order = orderRepository.save(order);

//        //forcefully throwing exception for testing
//        System.out.println(10/0);

        //build outbox message
        OutboxMessage outBoxMessage = outBoxEntityMapper.map(order);
        outboxMessageRepository.save(outBoxMessage);

        return order;
    }


}
