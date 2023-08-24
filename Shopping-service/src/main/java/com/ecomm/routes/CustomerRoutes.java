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


import com.ecomm.model.Customer;

@FeignClient(name="ECOM-CUSTOMER-SERVICE")
//@RequestMapping("/app")
public interface CustomerRoutes {
	

	@PostMapping("/app/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer);

	@GetMapping("/app/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id);

	@PutMapping("/app/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id);

	@DeleteMapping("/app/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer id);

}


