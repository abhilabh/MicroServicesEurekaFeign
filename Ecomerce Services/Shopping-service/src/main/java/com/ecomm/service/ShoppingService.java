package com.ecomm.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Order;
import com.ecomm.model.Product;

public interface ShoppingService {
	public ResponseEntity<Map<String, Integer>> addProduct(Product product);
	public Customer addCustomer(Customer customer);
	public void addToCard(Cart cart);
	public void createOrder(Order order);
	public void getOrder(Integer id);

}
