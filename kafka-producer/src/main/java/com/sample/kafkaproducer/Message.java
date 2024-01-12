package com.sample.kafkaproducer;

public class Message {
    private String message;
    private Integer count;

    public Message(String message, Integer count) {
        this.message = message;
        this.count = count;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", count=" + count +
                '}';
    }
}
