package com.ecomm.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ecomm.exception.CartException;
import com.ecomm.model.Cart;
import com.ecomm.repo.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public ResponseEntity<?> addCart(Cart cart) {
		cartRepository.save(cart);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getCart(Integer id) {
		// TODO Auto-generated method stub
		Optional<Cart> cartOptional = cartRepository.findById(id);
		Cart cart = null;
		System.out.println(cartOptional.isPresent());
		if (cartOptional.isPresent()) {
			cart = cartOptional.get();
		} else {
//			throw new CartException.CartIdNotFound("Id not found");
		}
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateCart(Cart cart, Integer id) {
		if (!cartRepository.existsById(id)) {
			throw new CartException.CartIdNotFound("Id not found");
		}
		cartRepository.save(cart);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteCart(Integer id) {
		if (!cartRepository.existsById(id)) {
			throw new CartException.CartIdNotFound("Id not found");
		}
		cartRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

}
