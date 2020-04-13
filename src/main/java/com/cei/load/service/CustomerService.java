package com.cei.load.service;

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
}
