package com.cei.load.service;

import java.util.List;

import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadDTO;

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
	void save(LoadDTO load);
}
