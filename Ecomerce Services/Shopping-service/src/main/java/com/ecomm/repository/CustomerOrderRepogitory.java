package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.CustomerCart;
import com.ecomm.model.CustomerOrder;

public interface CustomerOrderRepogitory extends JpaRepository<CustomerOrder, Integer> {

}
