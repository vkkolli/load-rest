package com.cei.load.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cei.load.exception.BusinessException;
import com.cei.load.service.ZipcodeService;

/**
 * The Class ZipcodeRestController.
 */
@RestController 
@RequestMapping("/zipcode")
public class ZipcodeRestController {
	
	/** The zipcode service. */
	@Autowired
	ZipcodeService zipcodeService;
	
	/**
	 * Search zipcode.
	 *
	 * @param criteria the criteria
	 * @return the response entity
	 * @throws BusinessException the business exception
	 */
	@RequestMapping(value = "/search/{criteria}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> searchZipcode(@PathVariable String criteria) throws BusinessException{
		List<?> searchCityStateZips = zipcodeService.searchCityStateZips(criteria, "USA");
		return new ResponseEntity<List<?>>(searchCityStateZips, HttpStatus.OK);
	}
	
}
