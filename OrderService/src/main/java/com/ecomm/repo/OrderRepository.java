package com.ecomm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
