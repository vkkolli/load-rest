package com.cei.load.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cei.load.domain.Customer;

/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	/**
	 * Find all customer by company name.
	 *
	 * @param companyName the company name
	 * @return the list
	 */
	@Query("select c from Customer c where LOWER(c.company) like LOWER(:criteria)")
	List<Customer> findAllCustomerByCompanyName(@Param("criteria") String companyName);
	
	
}
