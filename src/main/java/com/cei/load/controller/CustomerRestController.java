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

/**
 * The Class CustomerRestController.
 */
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	/** The customer service. */
	@Autowired
	CustomerService customerService;
	
	/**
	 * Save.
	 *
	 * @param customer the customer
	 * @return the response entity
	 */
	@RequestMapping("/create")
	public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer) {
		customer = customerService.save(customer);
		return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
	}
	
	/**
	 * Edits the.
	 *
	 * @param customerId the customer id
	 * @return the response entity
	 */
	@RequestMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> edit(@PathVariable Long customerId) {
		CustomerDTO customer = customerService.fetchCustomerById(customerId);
		return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
	}
}
