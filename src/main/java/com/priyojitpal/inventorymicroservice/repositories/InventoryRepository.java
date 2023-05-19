package com.priyojitpal.inventorymicroservice.repositories;

import com.priyojitpal.inventorymicroservice.entities.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, String> {
}
