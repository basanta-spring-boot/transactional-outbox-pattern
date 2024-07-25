package com.javatechie.repository;

import com.javatechie.entity.OutboxMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxMessageRepository extends JpaRepository<OutboxMessage,Long> {

    // Method to find all messages where processed is false
    List<OutboxMessage> findByProcessedFalse();
}
