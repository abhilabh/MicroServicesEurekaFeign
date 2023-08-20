package com.ecomm.service;

import org.springframework.http.ResponseEntity;

import com.ecomm.model.Customer;

public interface CustomerService {
	
	public ResponseEntity<?> addCustomer(Customer customer);
	public ResponseEntity<?> getCustomer(Integer id);
	public ResponseEntity<?> updateCustomer(Customer customer, Integer id);
	public ResponseEntity<?> deleteCustomer(Integer id);

}