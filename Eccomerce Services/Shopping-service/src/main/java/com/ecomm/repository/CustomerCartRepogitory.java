package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.CustomerCart;

public interface CustomerCartRepogitory extends JpaRepository<CustomerCart, Integer> {

}
