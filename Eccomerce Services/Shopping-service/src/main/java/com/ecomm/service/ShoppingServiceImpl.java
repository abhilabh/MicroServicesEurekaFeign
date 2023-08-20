package com.ecomm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Inventory;
import com.ecomm.model.Order;
import com.ecomm.model.Product;
import com.ecomm.routes.InventoryRoutes;
import com.ecomm.routes.ProductCatalogueRoutes;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	InventoryRoutes inventoryRoutes;

	@Autowired
	ProductCatalogueRoutes productCatalogueRoutes;

	@Override
	@CircuitBreaker(name = "product", fallbackMethod = "productFallBack")
	public ResponseEntity<Map<String, Integer>> addProduct(Product product) {
		ResponseEntity<Product> resProduct = productCatalogueRoutes.addProduct(product);
		Integer productId = resProduct.getBody().getProductId();
		product.setProductId(productId);
		Inventory inventory = new Inventory();
		inventory.setProductId(productId);
		inventory.setQuantity(1);
		ResponseEntity<Inventory> resInventory = inventoryRoutes.addInventory(inventory);
		;
		Integer inventoryId = resInventory.getBody().getInventoryId();
		Map<String, Integer> map = new HashMap<>();
		map.put("productId", productId);
		map.put("inventoryId", inventoryId);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	public ResponseEntity<String> productFallBack(Product product, Throwable trThrowable) {
		System.out.println(product);
		if (product.getProductId() != 0) {
			
			ResponseEntity<String> responseEntity = productCatalogueRoutes.deleteProduct(product.getProductId());
			System.out.println(product);
		}
		return new ResponseEntity<>("Product not added services unavailable", HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToCard(Cart cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOrder(Integer id) {
		// TODO Auto-generated method stub

	}

}
