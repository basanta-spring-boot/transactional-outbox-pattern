package com.javatechie.repository;

import com.javatechie.entity.OutboxMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxMessageRepository extends JpaRepository<OutboxMessage,Long> {

}
