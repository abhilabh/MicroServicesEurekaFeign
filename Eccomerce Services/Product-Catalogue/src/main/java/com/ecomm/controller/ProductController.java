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
import com.ecomm.exception.ProductException;
import com.ecomm.model.Product;
import com.ecomm.service.ProductService;

@RestController
@RequestMapping("/app")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		// TODO Auto-generated constructor stub
		this.productService = productService;
	}
	

	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		System.out.println(product);
		return productService.addProduct(product);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") Integer id) {
		return productService.getProduct(id);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") Integer id) {
		return productService.updateProduct(product, id);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		return productService.deleteProduct(id);
	}

	@ExceptionHandler(value = ProductException.ProductIdNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleCustomerAlreadyExistsException(ProductException.ProductIdNotFound ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
