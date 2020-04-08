package com.cei.load.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cei.load.model.CustomerDTO;
import com.cei.load.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/create")
	public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer) {
		customer = customerService.save(customer);
		return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<CustomerDTO> edit(@PathVariable Long customerId) {
		CustomerDTO customer = customerService.fetchCustomerById(customerId);
		return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
	}
}
