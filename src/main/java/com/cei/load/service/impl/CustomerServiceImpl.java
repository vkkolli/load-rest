package com.cei.load.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cei.load.domain.Customer;
import com.cei.load.model.CustomerDTO;
import com.cei.load.repository.CustomerRepository;
import com.cei.load.service.CustomerService;

/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadServiceImpl.class);

	/** The customer repo. */
	@Autowired
	CustomerRepository customerRepo;

	/** The model maper. */
	@Autowired
	ModelMapper modelMaper;

	/**
	 * Save.
	 *
	 * @param customer the customer
	 * @return the customer DTO
	 */
	@Override
	public CustomerDTO save(CustomerDTO customer) {
		LOGGER.info("Saving customer");
		Customer customerEntity = modelMaper.map(customer, Customer.class);
		customer = modelMaper.map(customerRepo.save(customerEntity), CustomerDTO.class);
		return customer;
	}

	/**
	 * Fetch customer by id.
	 *
	 * @param customerId the customer id
	 * @return the customer DTO
	 */
	@Override
	public CustomerDTO fetchCustomerById(Long customerId) {
		LOGGER.info("Fetching customer for id : {}", customerId);
		Optional<Customer> customerEntity = customerRepo.findById(customerId);
		return modelMaper.map(customerEntity.get(), CustomerDTO.class);
	}

	/**
	 * Fetch customers by name.
	 *
	 * @param customerName the customer name
	 * @return the list
	 */
	@Override
	public List<CustomerDTO> fetchCustomersByName(String customerName) {
		List<Customer> customers = customerRepo.findAllCustomerByCompanyName(customerName+"%");
		return modelMaper.map(customers, modelMapperCustomerDTOListType());
	}

	/**
	 * Model mapper lookup DTO list type.
	 *
	 * @return the type
	 */
	private Type modelMapperCustomerDTOListType() {
		Type listType = new TypeToken<List<CustomerDTO>>() {
		}.getType();

		return listType;
	}

}
