package com.ecomm.service;

import org.springframework.http.ResponseEntity;

import com.ecomm.model.Cart;

public interface CartService {
	
	public ResponseEntity<?> addCart(Cart cart);
	public ResponseEntity<?> getCart(Integer id);
	public ResponseEntity<?> updateCart(Cart cart, Integer id);
	public ResponseEntity<?> deleteCart(Integer id);

}