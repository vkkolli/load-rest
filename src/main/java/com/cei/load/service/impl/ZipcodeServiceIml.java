package com.cei.load.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cei.load.exception.BusinessException;
import com.cei.load.repository.ZipcodeRepository;
import com.cei.load.service.ZipcodeService;

/**
 * The Class ZipcodeServiceIml.
 */
@Service
public class ZipcodeServiceIml implements ZipcodeService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	/** The zipcode repository. */
	@Autowired
	ZipcodeRepository zipcodeRepository;
	
	/**
	 * Search city state zips.
	 *
	 * @param criteria the criteria
	 * @param countryCode the country code
	 * @return the list
	 * @throws BusinessException the business exception
	 */
	public List<?> searchCityStateZips(String criteria, String countryCode) throws BusinessException {
	    List<?> searchZipList = null;
	    LOGGER.info("searchCityStateZipReturnDtos - search text {}", criteria);
	    if (StringUtils.isEmpty(criteria))
	      throw new BusinessException(HttpStatus.BAD_REQUEST.value(), 300, "Enter city/state/zip text", "Zipcode serach input is null"); 
	    criteria = criteria.toLowerCase() + "%";
	    if (null == countryCode) {
	      countryCode = "USA";
	    } else {
	      countryCode = countryCode.toUpperCase();
	    } 
	    LOGGER.info("criteria : {}", criteria);
	    try {
	      if (StringUtils.isNumeric(criteria.substring(1, criteria.length() - 1))) {
	        searchZipList = this.zipcodeRepository.searchCityStateZipByZipCodeAndCountryCode(criteria, countryCode);
	      } else {
	        searchZipList = this.zipcodeRepository.searchCityStateZips(criteria);
	      } 
	      if (null != searchZipList && !searchZipList.isEmpty()) {
	        LOGGER.info("searchCitySateZipcode ::::: {}", Integer.valueOf(searchZipList.size()));
	      } else {
	        throw new BusinessException(HttpStatus.NOT_FOUND.value(), 300, "Search city/state/zip not found", "Zipcode serach output is null");
	      } 
	    } catch (Exception ex) {
	      LOGGER.error("Exception searching zipcode : {}", ex.getCause());
	      throw ex;
	    } 
	    return searchZipList;
	  }
}
