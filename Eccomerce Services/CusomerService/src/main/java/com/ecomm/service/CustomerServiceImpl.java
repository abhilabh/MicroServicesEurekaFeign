package com.ecomm.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ecomm.exception.CustomerException;
import com.ecomm.model.Customer;
import com.ecomm.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<?> addCustomer(Customer customer) {
		customerRepository.save(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getCustomer(Integer id) {
		// TODO Auto-generated method stub
		Optional<Customer> customerOptional = customerRepository.findById(id);
		Customer customer = null;
		System.out.println(customerOptional.isPresent());
		if (customerOptional.isPresent()) {
			customer = customerOptional.get();
		} else {
//			throw new CustomerException.CustomerIdNotFound("Id not found");
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateCustomer(Customer customer, Integer id) {
		if (!customerRepository.existsById(id)) {
			throw new CustomerException.CustomerIdNotFound("Id not found");
		}
		customerRepository.save(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteCustomer(Integer id) {
		if (!customerRepository.existsById(id)) {
			throw new CustomerException.CustomerIdNotFound("Id not found");
		}
		customerRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

}
