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
import com.ecomm.exception.OrderException;
import com.ecomm.model.Order;
import com.ecomm.service.OrderService;

@RestController
@RequestMapping("/app")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		// TODO Auto-generated constructor stub
		this.orderService = orderService;
	}
	

	@PostMapping("/order")
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
//		System.out.println(order);
		return orderService.addOrder(order);
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<?> getOrder(@PathVariable("id") Integer id) {
		return orderService.getOrder(id);
	}

	@PutMapping("/order/{id}")
	public ResponseEntity<?> updateOrder(@RequestBody Order order, @PathVariable("id") Integer id) {
		return orderService.updateOrder(order, id);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") Integer id) {
		return orderService.deleteOrder(id);
	}

	@ExceptionHandler(value = OrderException.OrderIdNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleOrderAlreadyExistsException(OrderException.OrderIdNotFound ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
