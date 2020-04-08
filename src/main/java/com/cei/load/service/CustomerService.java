package com.cei.load.service;

import com.cei.load.model.CustomerDTO;

public interface CustomerService {
	
	CustomerDTO save(CustomerDTO customer);
	
	CustomerDTO fetchCustomerById(Long customerId);
}
