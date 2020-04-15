package com.cei.load.service;

import java.util.List;

import com.cei.load.model.CustomerDTO;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {
	
	/**
	 * Save.
	 *
	 * @param customer the customer
	 * @return the customer DTO
	 */
	CustomerDTO save(CustomerDTO customer);
	
	/**
	 * Fetch customer by id.
	 *
	 * @param customerId the customer id
	 * @return the customer DTO
	 */
	CustomerDTO fetchCustomerById(Long customerId);
	
	/**
	 * Fetch customers by name.
	 *
	 * @param customerName the customer name
	 * @return the list
	 */
	List<CustomerDTO> fetchCustomersByName(String customerName);
}
