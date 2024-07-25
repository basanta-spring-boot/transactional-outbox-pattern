package com.javatechie.service;

import com.javatechie.entity.OutboxMessage;
import com.javatechie.publisher.MessagePublisher;
import com.javatechie.repository.OutboxMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OutBoxMessagePollerService {

    @Autowired
    private OutboxMessageRepository outboxMessageRepository;

    @Autowired
    private MessagePublisher messagePublisher;


    @Scheduled(fixedRate = 60000)
    public void pollOutBoxMessagesAndPublish() {

        //fetch all unprocessed messages from DB
        List<OutboxMessage> unProcessedMessages = outboxMessageRepository.findByProcessedFalse();

        log.info("unprocessed message found {} : ",unProcessedMessages.size());
        unProcessedMessages.forEach(outboxMessage -> {
            try {
                //publish message to kafka
                messagePublisher.publish(outboxMessage);
                //update message status to processed to avoid duplicate message
                outboxMessage.setProcessed(true);
                outboxMessageRepository.save(outboxMessage);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

    }
}
