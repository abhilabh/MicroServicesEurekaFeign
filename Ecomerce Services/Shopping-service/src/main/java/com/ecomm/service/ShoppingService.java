package com.ecomm.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Order;
import com.ecomm.model.Product;

public interface ShoppingService {
	public ResponseEntity<Map<String, Integer>> addProduct(Product product);
	public ResponseEntity<Map<String, Integer>> addCustomer(Customer customer);
	public ResponseEntity<Cart> addToCard(Cart cart, int customerId);
	public ResponseEntity<Order> createOrder(int customerId);
	public ResponseEntity<List<Order>> getOrders(Integer id);
}
