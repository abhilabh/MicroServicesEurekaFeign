package com.ecomm.service;

import org.springframework.http.ResponseEntity;

import com.ecomm.model.Order;

public interface OrderService {
	
	public ResponseEntity<?> addOrder(Order order);
	public ResponseEntity<?> getOrder(Integer id);
	public ResponseEntity<?> updateOrder(Order order, Integer id);
	public ResponseEntity<?> deleteOrder(Integer id);

}