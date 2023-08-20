package com.ecomm.service;

import org.springframework.http.ResponseEntity;

import com.ecomm.model.Product;

public interface ProductService {
	
	public ResponseEntity<Product> addProduct(Product product);
	public ResponseEntity<Product> getProduct(Integer id);
	public ResponseEntity<Product> updateProduct(Product product, Integer id);
	public ResponseEntity<?> deleteProduct(Integer id);

}