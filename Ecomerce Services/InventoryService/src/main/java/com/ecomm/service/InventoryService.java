package com.ecomm.service;

import org.springframework.http.ResponseEntity;

import com.ecomm.model.Inventory;

public interface InventoryService {
	
	public ResponseEntity<?> addInventory(Inventory inventory);
	public ResponseEntity<?> getInventory(Integer id);
	public ResponseEntity<?> updateInventory(Inventory inventory, Integer id);
	public ResponseEntity<?> deleteInventory(Integer id);

}