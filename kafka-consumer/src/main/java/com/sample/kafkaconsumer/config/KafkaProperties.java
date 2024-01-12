package com.sample.kafkaconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProperties {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.item-topic}")
    private String itemTopic;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getItemTopic() {
        return itemTopic;
    }

    public void setItemTopic(String itemTopic) {
        this.itemTopic = itemTopic;
    }
}
