package com.ecomm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Order;
import com.ecomm.model.Product;
import com.ecomm.service.ShoppingService;

@RestController
@RequestMapping("/api/shoppingservice")
public class ShoppingController {
	
	@Autowired
	ShoppingService shoppingService;
	
	@PostMapping("/products")
	public ResponseEntity<Map<String, Integer>> addProduct(@RequestBody Product product) {
		ResponseEntity<Map<String, Integer>> resProduct =  shoppingService.addProduct(product);
		return resProduct;
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Map<String, Integer>> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Map<String, Integer>> resCustomer =  shoppingService.addCustomer(customer);
		return resCustomer;
	}
	
	@PutMapping("/customer/{customerId}/cart")
	
	public void addToCart(@RequestBody Cart cart, @PathVariable("customerId") int customerId) {
		shoppingService.addToCard(cart, customerId);
	}
	@PostMapping("/customer/{customerId}/order")
	public void placeOrder(@RequestBody Order order, @PathVariable("customerId") int customerId) {
		shoppingService.createOrder(customerId);
	}
	
	@GetMapping("/customer/{customerId}/orders")
	public ResponseEntity<List<Order>> getOrders(@PathVariable("customerId") int customerId) {
		return shoppingService.getOrders(customerId);
	}
}
