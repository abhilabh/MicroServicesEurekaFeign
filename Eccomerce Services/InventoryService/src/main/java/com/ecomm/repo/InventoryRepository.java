package com.ecomm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
