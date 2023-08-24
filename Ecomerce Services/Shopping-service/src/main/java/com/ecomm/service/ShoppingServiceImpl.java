package com.ecomm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.CustomerCart;
import com.ecomm.model.CustomerOrder;
import com.ecomm.model.CustomerOrderId;
import com.ecomm.model.Inventory;
import com.ecomm.model.Order;
import com.ecomm.model.Product;
import com.ecomm.repository.CustomerCartRepogitory;
import com.ecomm.repository.CustomerOrderRepogitory;
import com.ecomm.routes.CustomerCartRoutes;
import com.ecomm.routes.CustomerOrderRoutes;
import com.ecomm.routes.CustomerRoutes;
import com.ecomm.routes.InventoryRoutes;
import com.ecomm.routes.ProductCatalogueRoutes;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	InventoryRoutes inventoryRoutes;

	@Autowired
	ProductCatalogueRoutes productCatalogueRoutes;
	
	@Autowired
	CustomerRoutes customerRoutes;
	
	@Autowired
	CustomerCartRoutes cartRoutes;
	
	@Autowired
	CustomerOrderRoutes customerOrderRoutes;
	
	@Autowired
	CustomerCartRepogitory customerCartRepogitory;
	
	@Autowired
	CustomerOrderRepogitory customerOrderRepogitory;

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
	public  ResponseEntity<Map<String, Integer>> addCustomer(Customer customer) {
		ResponseEntity<Customer> resCustomer = customerRoutes.addCustomer(customer);
		Integer customerId = resCustomer.getBody().getCustomerId();
		Cart cart = new Cart();
		
		ResponseEntity<Cart> resCart = cartRoutes.addCart(cart);
		Integer cartId = resCart.getBody().getCartId();
		CustomerCart customerCart = new CustomerCart();
		customerCart.setCutomerId(customerId);
		customerCart.setCartId(cartId);
		customerCartRepogitory.save(customerCart);
		Map<String, Integer> map = new HashMap<>();
		map.put("customerId", customerId);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Cart> addToCard(Cart cart, int customerId) {
		System.out.println(cart);
		CustomerCart customerCart = customerCartRepogitory.findById(customerId).orElse(null);
		cart.setCartId(customerCart.getCartId());
		ResponseEntity<Cart> resCart = cartRoutes.updateCart(cart, cart.getCartId());
		return new ResponseEntity<>(resCart.getBody(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Order> createOrder(int customerId) {
		CustomerCart customerCart = customerCartRepogitory.findById(customerId).orElse(null);
		int cartId = customerCart.getCartId();
		//get card details
		Cart resCart = cartRoutes.getCart(cartId).getBody();
		//add order
		System.out.println(resCart);
		Order order = new Order();
		order.setLineItems(resCart.getLineItems());
		order.getLineItems().forEach(x->x.setItemId(null));
		System.out.println(order);
		ResponseEntity<Order> resOrder = customerOrderRoutes.addOrder(order);
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCutomerId(customerId);
		
		//update inventory
		resCart.getLineItems().forEach(lineitem-> {
			Inventory inventory = inventoryRoutes.geInventoryByProductId(lineitem.getProductId()).getBody();
			inventory.setQuantity(inventory.getQuantity() - lineitem.getQuantity());
			inventory = inventoryRoutes.updateInventory(inventory, inventory.getInventoryId()).getBody();

		});
		Cart cart = new Cart();
		cart.setCartId(customerCart.getCartId());
		
		resCart = cartRoutes.updateCart(cart, cartId).getBody();
		List<CustomerOrderId> list = new ArrayList<>();
		CustomerOrderId customerOrderId = new CustomerOrderId();
		customerOrderId.setOrderId(resOrder.getBody().getOrderId());
		list.add(customerOrderId);
		customerOrderId.setCOrder(customerOrder);
		customerOrder.setOrderIdList(list);
		
		customerOrderRepogitory.save(customerOrder);
		
		return new ResponseEntity<>(resOrder.getBody(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<Order>> getOrders(Integer id) {
		CustomerOrder customerOrder = customerOrderRepogitory.findById(id).orElse(null);
		List<Order> Orders = new ArrayList<>();
		for (CustomerOrderId customerOrderId: customerOrder.getOrderIdList()) {
			ResponseEntity<Order> resOrder = customerOrderRoutes.getOrder(customerOrderId.getOrderId());
			Orders.add(resOrder.getBody());
		}
		return new ResponseEntity<>(Orders, HttpStatus.OK);
	}

}
