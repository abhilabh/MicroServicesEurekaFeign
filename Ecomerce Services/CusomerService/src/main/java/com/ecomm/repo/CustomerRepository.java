package com.ecomm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
