package com.cei.load.service;

import java.util.List;

import com.cei.load.exception.BusinessException;

/**
 * The Interface ZipcodeService.
 */
public interface ZipcodeService {
	
	/**
	 * Search city state zips.
	 *
	 * @param criteria the criteria
	 * @param countryCode the country code
	 * @return the list
	 * @throws BusinessException the business exception
	 */
	List<?> searchCityStateZips(String criteria, String countryCode) throws BusinessException;
}
