package com.cei.load.service;

import java.util.List;

import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadDTO;
import com.cei.load.model.LookupDTO;

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
}
