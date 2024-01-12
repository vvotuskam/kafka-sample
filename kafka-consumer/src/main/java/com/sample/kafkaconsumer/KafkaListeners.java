package com.sample.kafkaconsumer;

import com.sample.kafkaconsumer.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final Logger log = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "${spring.kafka.item-topic}",
            groupId = "kafka-listener",
            containerFactory = "containerFactory"
    )
    void itemListener(@Payload Item item) {
        log.info("Received {} from Kafka", item);
    }
}
