package com.priyojitpal.inventorymicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryUpdateRequest {
    private String inventoryId;
    private int inventoryQuantity;
}
