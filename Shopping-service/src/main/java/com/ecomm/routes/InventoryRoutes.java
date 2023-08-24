package com.ecomm.routes;

import org.springframework.cloud.openfeign.FeignClient;
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


import com.ecomm.model.Inventory;

@FeignClient(name="ECOM-INVENTORY-SERVICE")
//@RequestMapping("/app")
public interface InventoryRoutes {
	

	@PostMapping("/app/inventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory);

	@GetMapping("/app/inventory/{id}")
	public ResponseEntity<Inventory> getInventory(@PathVariable("id") Integer id);
	
	@GetMapping("/app/inventory/product/{id}")
	public ResponseEntity<Inventory> geInventoryByProductId(@PathVariable("id") Integer productId);

	@PutMapping("/app/inventory/{id}")
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory, @PathVariable("id") Integer id);

	@DeleteMapping("/app/inventory/{id}")
	public ResponseEntity<String> deleteInventory(@PathVariable("id") Integer id);

}
