package com.sample.kafkaproducer;

import com.sample.kafkaproducer.config.KafkaProperties;
import com.sample.kafkaproducer.item.Item;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class KafkaProducer {

    private final KafkaProperties properties;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaProperties properties, KafkaTemplate<String, Object> kafkaTemplate) {
        this.properties = properties;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Message message) {
        IntStream.range(0, message.getCount())
                .forEach(i ->
                        kafkaTemplate.send(properties.getItemTopic(), new Item(message.getMessage()))
                );
    }
}
