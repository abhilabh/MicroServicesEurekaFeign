package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.exception.ErrorResponse;
import com.ecomm.exception.InventoryException;
import com.ecomm.model.Inventory;
import com.ecomm.service.InventoryService;

@RestController
@RequestMapping("/app")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		// TODO Auto-generated constructor stub
		this.inventoryService = inventoryService;
	}
	

	@PostMapping("/inventory")
	public ResponseEntity<?> addInventory(@RequestBody Inventory inventory) {
		System.out.println(inventory);
		return inventoryService.addInventory(inventory);
	}

	@GetMapping("/inventory/{id}")
	public ResponseEntity<?> getInventory(@PathVariable("id") Integer id) {
		return inventoryService.getInventory(id);
	}
	
	@GetMapping("/inventory/product/{id}")
	public ResponseEntity<?> getInventoryByProductId(@PathVariable("id") Integer id) {
		return inventoryService.getInventoryByProductId(id);
	}

	@PutMapping("/inventory/{id}")
	public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory, @PathVariable("id") Integer id) {
		return inventoryService.updateInventory(inventory, id);
	}

	@DeleteMapping("/inventory/{id}")
	public ResponseEntity<?> deleteInventory(@PathVariable("id") Integer id) {
		return inventoryService.deleteInventory(id);
	}

	@ExceptionHandler(value = InventoryException.InventoryIdNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleCustomerAlreadyExistsException(InventoryException.InventoryIdNotFound ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
