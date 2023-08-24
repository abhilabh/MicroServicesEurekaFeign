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


import com.ecomm.model.Cart;

@FeignClient(name="ECOM-CART-SERVICE")
//@RequestMapping("/app")
public interface CustomerCartRoutes {
	

	@PostMapping("/app/cart")
	public ResponseEntity<?> addCart(@RequestBody Cart cart);

	@GetMapping("/app/cart/{id}")
	public ResponseEntity<?> getCart(@PathVariable("id") Integer id);

	@PutMapping("/app/cart/{id}")
	public ResponseEntity<?> updateCart(@RequestBody Cart cart, @PathVariable("id") Integer id);

	@DeleteMapping("/app/cart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable("id") Integer id);

}

