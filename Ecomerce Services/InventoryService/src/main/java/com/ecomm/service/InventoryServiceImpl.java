package com.ecomm.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ecomm.exception.InventoryException;
import com.ecomm.model.Inventory;
import com.ecomm.repo.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public ResponseEntity<?> addInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
		return new ResponseEntity<>(inventory, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getInventory(Integer id) {
		// TODO Auto-generated method stub
		Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
		Inventory inventory = null;
		if (inventoryOptional.isPresent()) {
			inventory = inventoryOptional.get();
		} else {
			throw new InventoryException.InventoryIdNotFound("Id not found");
		}
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateInventory(Inventory inventory, Integer id) {
		if (!inventoryRepository.existsById(id)) {
			throw new InventoryException.InventoryIdNotFound("Id not found");
		}
		inventoryRepository.save(inventory);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteInventory(Integer id) {
		if (!inventoryRepository.existsById(id)) {
			throw new InventoryException.InventoryIdNotFound("Id not found");
		}
		inventoryRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

}
