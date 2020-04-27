package com.cei.load.repository;

import com.cei.load.domain.Carrier;
import com.cei.load.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {
	
	/**
	 * Find all carrier by carrier name.
	 *
	 * @param carrierName the carrier name
	 * @return the list
	 */
	@Query("select c from Carrier c where LOWER(c.carrier) like LOWER(:criteria)")
	List<Carrier> findAllCarrierByCarrierName(@Param("criteria") String carrierName);
	
	
}
