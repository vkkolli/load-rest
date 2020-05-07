package com.cei.load.service;

import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadBoardDTO;
import com.cei.load.model.LoadCarrierDTO;
import com.cei.load.model.LoadDTO;
import com.cei.load.model.LookupDTO;
import com.cei.load.model.PickupDeliveryDatesDTO;

import java.text.ParseException;
import java.util.List;



/**
 * The Interface LoadService.
 */
public interface LoadService {
	
	/**
	 * Gets the all active loads.
	 *
	 * @return the all active loads
	 */
	APIResponse getAllActiveLoads();
	
	/**
	 * Gets the all load.
	 *
	 * @return the all load
	 */
	List<LoadDTO> getAllLoad();

	/**
	 * Save.
	 *
	 * @param load the load
	 */
	LoadDTO save(LoadDTO load);
	
	/**
	 * Gets the load by id.
	 *
	 * @param loadId the load id
	 * @return the load by id
	 */
	LoadDTO getLoadById(Long loadId);
	
	/**
	 * Gets the active equipment.
	 *
	 * @return the active equipment
	 */
	List<LookupDTO> getActiveEquipment();

	/**
	 * Assign carrier.
	 *
	 * @param loadCarrier the load carrier
	 */
	LoadDTO assignCarrier(LoadCarrierDTO loadCarrier);
	
	/**
	 * Gets the all active load status.
	 *
	 * @return the all active load status
	 */
	List<LookupDTO> getAllActiveLoadStatus();

	LoadBoardDTO setPickupConfirmed(PickupDeliveryDatesDTO pickupDeliveryDatesDTO) throws ParseException;
}
