package com.priyojitpal.inventorymicroservice.controllers;

import com.priyojitpal.inventorymicroservice.entities.Inventory;
import com.priyojitpal.inventorymicroservice.models.InventoryRequest;
import com.priyojitpal.inventorymicroservice.services.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/createInventory")
    public ResponseEntity<Inventory> createInventory(@RequestBody InventoryRequest inventoryRequest) {
        Optional<Inventory> inventory = inventoryService.createInventory(inventoryRequest);
        if (inventory.isPresent())
            return ResponseEntity.ok(inventory.get());
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAllInventories")
    public ResponseEntity<Iterable<Inventory>> getAllInventories() {
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }
}
