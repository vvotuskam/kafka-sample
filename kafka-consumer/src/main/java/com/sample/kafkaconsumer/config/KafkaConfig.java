package com.sample.kafkaconsumer.config;

import com.sample.kafkaconsumer.item.Item;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaConfig {

    private final KafkaProperties properties;

    public KafkaConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public NewTopic itemTopic() {
        return TopicBuilder.name(properties.getItemTopic()).build();
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public KafkaListenerContainerFactory<?> containerFactory(
            ConsumerFactory<String, Object> consumerFactory
    ) {
        var containerFactory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
        containerFactory.setConsumerFactory(consumerFactory);
        return containerFactory;
    }

    private Map<String, Object> consumerConfig() {
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers(),
                ConsumerConfig.GROUP_ID_CONFIG, "kafka-listener",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class,
                JsonDeserializer.TYPE_MAPPINGS, "item:com.sample.kafkaconsumer.item.Item",
                JsonDeserializer.TRUSTED_PACKAGES, "*"
        );
    }


}
