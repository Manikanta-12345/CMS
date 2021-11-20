package com.cms.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.Customer;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@PostMapping(value = "/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {

		String customerId = UUID.randomUUID().toString();

		customer.setCustomerId(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);

	}
	@GetMapping(value = "/customers")
	public ResponseEntity<Customer> getCustomers() throws UnknownHostException {
		String customerId = UUID.randomUUID().toString();
        Customer customer=new Customer();
		customer.setCustomerId(customerId);
		customer.setAge(40);
		customer.setCity("Hyderabad");
		customer.setName("Alex");
		customer.setPolicy("Jeevan Umang");
		customer.setServer(InetAddress.getLocalHost().toString());
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}
}
