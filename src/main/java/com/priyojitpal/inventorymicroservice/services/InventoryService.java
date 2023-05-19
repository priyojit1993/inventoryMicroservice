package com.priyojitpal.inventorymicroservice.services;

import com.priyojitpal.inventorymicroservice.entities.Inventory;
import com.priyojitpal.inventorymicroservice.models.InventoryRequest;
import com.priyojitpal.inventorymicroservice.models.InventoryUpdateRequest;
import com.priyojitpal.inventorymicroservice.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Optional<Inventory> createInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = new Inventory(inventoryRequest.getInventoryId(), inventoryRequest.getProductId(), inventoryRequest.getProductName(), inventoryRequest.getProductQuantity());
        return Optional.of(inventoryRepository.save(inventory));
    }

    public Optional<Inventory> updateInventoryQuantity(InventoryUpdateRequest inventoryUpdateRequest) {
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryUpdateRequest.getInventoryId());
        if (inventory.isPresent()) {
            Inventory inventory1 = inventory.get();
            inventory1.setProductQuantity(inventoryUpdateRequest.getInventoryQuantity());
            inventoryRepository.save(inventory1);
            return Optional.of(inventory1);
        } else return Optional.empty();
    }

    public void decreaseInventoryCount(String inventoryId) {
        Optional<Inventory> byId = inventoryRepository.findById(inventoryId);
        if (byId.isPresent()) {
            var invenTory = byId.get();
            invenTory.setProductQuantity(invenTory.getProductQuantity() - 1);
            inventoryRepository.save(invenTory);
        }
    }

    public Iterable<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}
