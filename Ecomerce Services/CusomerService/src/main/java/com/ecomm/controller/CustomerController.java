package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.exception.ErrorResponse;
import com.ecomm.exception.CustomerException;
import com.ecomm.model.Customer;
import com.ecomm.service.CustomerService;

@RestController
@RequestMapping("/app")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		// TODO Auto-generated constructor stub
		this.customerService = customerService;
	}
	

	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		return customerService.addCustomer(customer);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") Integer id) {
		return customerService.getCustomer(id);
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id) {
		return customerService.updateCustomer(customer, id);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id) {
		return customerService.deleteCustomer(id);
	}

	@ExceptionHandler(value = CustomerException.CustomerIdNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleCustomerAlreadyExistsException(CustomerException.CustomerIdNotFound ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
