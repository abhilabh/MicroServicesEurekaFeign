package com.ecomm.routes;

import org.springframework.cloud.openfeign.FeignClient;
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


import com.ecomm.model.Product;

@FeignClient(name="ECOM-PRODUCT-CATALOGUE-SERVICE")
//@RequestMapping("/app")
public interface ProductCatalogueRoutes {
	

	@PostMapping("/app/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product);

	@GetMapping("/app/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id);

	@PutMapping("/app/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Integer id);

	@DeleteMapping("/app/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id);

}

