package com.cei.load.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cei.load.domain.Customer;

/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
