package com.sample.kafkaproducer.item;

import java.time.LocalDateTime;
import java.util.UUID;

public class Item {

    private final UUID id;
    private final String name;
    private final LocalDateTime createdAt;

    public Item(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
