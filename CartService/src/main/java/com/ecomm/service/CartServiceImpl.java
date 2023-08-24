package com.ecomm.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ecomm.exception.CartException;
import com.ecomm.model.Cart;
import com.ecomm.model.LineItems;
import com.ecomm.repo.CartRepository;
import com.thoughtworks.xstream.mapper.Mapper.Null;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public ResponseEntity<?> addCart(Cart cart) {
		if (cart.getLineItems() != null) {
			cart.getLineItems().forEach(x-> x.setCart(cart));
		}
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
			throw new CartException.CartIdNotFound("Id not found");
		}
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateCart(Cart cart, Integer id) {
		if (!cartRepository.existsById(id)) {
			throw new CartException.CartIdNotFound("Id not found");
		}
		System.out.println(cart);

		if (cart.getLineItems() == null)
			cart.setLineItems(new ArrayList<>());
		else
			cart.getLineItems().forEach(x -> x.setCart(cart));
		cart.setCartId(id);
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
