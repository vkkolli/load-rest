package com.cei.load.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cei.load.domain.Carrier;

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
	@Query("select c from Carrier c where LOWER(c.carrierName) like LOWER(:criteria)")
	List<Carrier> findAllCarrierByCarrierName(@Param("criteria") String carrierName);

}
