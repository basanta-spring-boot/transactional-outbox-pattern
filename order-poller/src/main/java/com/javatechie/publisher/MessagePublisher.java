package com.javatechie.publisher;

import com.javatechie.entity.OutboxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class MessagePublisher {


    @Autowired
    private KafkaTemplate<String, String> template;

    @Value("${order.poller.topic.name}")
    private String topicName;

    public void publish(OutboxMessage message) {

        // Publish message to Kafka, RabbitMQ, etc.

        CompletableFuture<SendResult<String, String>> future = template
                .send(topicName, message.getPayload());

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });

    }
}
