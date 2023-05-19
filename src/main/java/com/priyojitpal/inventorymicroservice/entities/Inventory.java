package com.priyojitpal.inventorymicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inventory {
    @MongoId
    private String inventoryId;
    private String productId;
    private String productName;
    private int productQuantity;
}
