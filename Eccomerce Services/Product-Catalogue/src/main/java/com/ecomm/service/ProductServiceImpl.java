package com.ecomm.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ecomm.exception.ProductException;
import com.ecomm.model.Product;
import com.ecomm.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ResponseEntity<Product> addProduct(Product product) {
		productRepository.save(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Product> getProduct(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> productOptional = productRepository.findById(id);
		Product product = null;
		if (productOptional.isPresent()) {
			product = productOptional.get();
		} else {
			throw new ProductException.ProductIdNotFound("Id not found");
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> updateProduct(Product product, Integer id) {
		if (!productRepository.existsById(id)) {
			throw new ProductException.ProductIdNotFound("Id not found");
		}
		productRepository.save(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteProduct(Integer id) {
		if (!productRepository.existsById(id)) {
			throw new ProductException.ProductIdNotFound("Id not found");
		}
		productRepository.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

}
