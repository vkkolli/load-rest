package com.cei.load.service;

import com.cei.load.model.CarrierDTO;
import java.util.List;

/**
 * The Interface CarrierService.
 */
public interface CarrierService {
	
	/**
	 * Save.
	 *
	 * @param carrier the carrier
	 * @return the carrier DTO
	 */
	CarrierDTO save(CarrierDTO carrier);
	
	/**
	 * Fetch carrier by id.
	 *
	 * @param carrierId the cvarrier id
	 * @return the carrier DTO
	 */
	CarrierDTO fetchCarrierById(Long carrierId);
	
	/**
	 * Fetch carrier by name.
	 *
	 * @param carrierName the customer name
	 * @return the list
	 */
	List<CarrierDTO> fetchCarriersByName(String carrierName);
	

}
