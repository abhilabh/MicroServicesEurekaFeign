package com.ecomm.routes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ecomm.model.Order;

@FeignClient(name="ECOM-ORDER-SERVICE")
//@RequestMapping("/app")
public interface CustomerOrderRoutes {
	

	@PostMapping("/app/order")
	public ResponseEntity<Order> addOrder(@RequestBody Order order);

	@GetMapping("/app/order/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id);

	@PutMapping("/app/order/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("id") Integer id);

	@DeleteMapping("/app/order/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id);
		
}

