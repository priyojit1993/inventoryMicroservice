package com.priyojitpal.inventorymicroservice.consumers;

import com.priyojitpal.inventorymicroservice.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryConsumer {
    private final InventoryService inventoryService;

    public InventoryConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(groupId = "inventory-consumer-group", topics = "inventory-order-communication-test")
    public void consumeInventoryAndDecreaseCount(String message) {
        log.info("Decreasing product count for "+message);
        inventoryService.decreaseInventoryCount(message);
    }
}
