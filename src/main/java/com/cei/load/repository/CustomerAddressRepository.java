package com.cei.load.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cei.load.domain.Address;

@Repository
public interface CustomerAddressRepository extends JpaRepository<Address, Long> {
	
	/**
	 * Find all by customer.
	 *
	 * @param customer the customer
	 * @return the list
	 */
	List<Address> findAllByCustomer(Long customerId);

}
