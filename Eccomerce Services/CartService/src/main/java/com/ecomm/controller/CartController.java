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
import com.ecomm.exception.CartException;
import com.ecomm.model.Cart;
import com.ecomm.service.CartService;

@RestController
@RequestMapping("/app")
public class CartController {

	@Autowired
	private CartService cartService;
	
	public CartController(CartService cartService) {
		// TODO Auto-generated constructor stub
		this.cartService = cartService;
	}
	

	@PostMapping("/cart")
	public ResponseEntity<?> addCart(@RequestBody Cart cart) {
		System.out.println(cart);
		return cartService.addCart(cart);
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<?> getCart(@PathVariable("id") Integer id) {
		return cartService.getCart(id);
	}

	@PutMapping("/cart/{id}")
	public ResponseEntity<?> updateCart(@RequestBody Cart cart, @PathVariable("id") Integer id) {
		return cartService.updateCart(cart, id);
	}

	@DeleteMapping("/cart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable("id") Integer id) {
		return cartService.deleteCart(id);
	}

	@ExceptionHandler(value = CartException.CartIdNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleCartAlreadyExistsException(CartException.CartIdNotFound ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
