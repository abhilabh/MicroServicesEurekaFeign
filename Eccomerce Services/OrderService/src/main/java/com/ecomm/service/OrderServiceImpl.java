package com.ecomm.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ecomm.exception.OrderException;
import com.ecomm.model.Order;
import com.ecomm.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public ResponseEntity<?> addOrder(Order order) {
		orderRepository.save(order);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getOrder(Integer id) {
		// TODO Auto-generated method stub
		Optional<Order> orderOptional = orderRepository.findById(id);
		Order order = null;
		System.out.println(orderOptional.isPresent());
		if (orderOptional.isPresent()) {
			order = orderOptional.get();
		} else {
//			throw new OrderException.OrderIdNotFound("Id not found");
		}
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateOrder(Order order, Integer id) {
		if (!orderRepository.existsById(id)) {
			throw new OrderException.OrderIdNotFound("Id not found");
		}
		orderRepository.save(order);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteOrder(Integer id) {
		if (!orderRepository.existsById(id)) {
			throw new OrderException.OrderIdNotFound("Id not found");
		}
		orderRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

}
