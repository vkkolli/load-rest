package com.cei.load.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cei.load.domain.Customer;
import com.cei.load.model.CustomerDTO;
import com.cei.load.repository.CustomerRepository;
import com.cei.load.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadServiceImpl.class);
	
	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	ModelMapper modelMaper;

	@Override
	public CustomerDTO save(CustomerDTO customer) {
		LOGGER.info("Saving customer");
		Customer customerEntity = modelMaper.map(customer, Customer.class);
		customer = modelMaper.map(customerRepo.save(customerEntity), CustomerDTO.class);
		return customer;
	}
	
	@Override
	public CustomerDTO fetchCustomerById(Long customerId) {
		LOGGER.info("Fetching customer for id : {}", customerId);
		Optional<Customer> customerEntity = customerRepo.findById(customerId);
		return modelMaper.map(customerEntity.get(), CustomerDTO.class);
	}

}
