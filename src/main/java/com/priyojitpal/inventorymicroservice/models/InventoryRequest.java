package com.priyojitpal.inventorymicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryRequest {
    private String inventoryId;
    private String productId;
    private String productName;
    private int productQuantity;
}
