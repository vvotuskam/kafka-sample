package com.sample.kafkaconsumer.item;

import java.time.LocalDateTime;
import java.util.UUID;

public class Item {

    private UUID id;
    private String name;
    private LocalDateTime createdAt;

    public Item() {

    }

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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
