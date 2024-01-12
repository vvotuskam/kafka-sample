package com.sample.kafkaproducer;

import com.sample.kafkaproducer.item.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody Message message) {
        kafkaProducer.send(message);
        return ResponseEntity.ok().build();
    }
}
