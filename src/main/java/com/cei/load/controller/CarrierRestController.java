package com.cei.load.controller;


import com.cei.load.model.CarrierDTO;
import com.cei.load.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Class CustomerRestController.
 */
@RestController
@RequestMapping("/carrier")
public class CarrierRestController {
	
	/** The customer service. */
	@Autowired
	CarrierService carrierService;
	
	/**
	 * Save.
	 *
	 * @param carrier the carrier
	 * @return the response entity
	 */
	@RequestMapping("/create")
	public ResponseEntity<CarrierDTO> save(@RequestBody CarrierDTO carrier) {
		carrier = carrierService.save(carrier);
		return new ResponseEntity<CarrierDTO>(carrier, HttpStatus.OK);
	}
	
	/**
	 * Edits the.
	 *
	 * @param carrierId the customer id
	 * @return the response entity
	 */
	@RequestMapping("/{carrierId}")
	public ResponseEntity<CarrierDTO> edit(@PathVariable Long carrierId) {
		CarrierDTO carrier = carrierService.fetchCarrierById(carrierId);
		return new ResponseEntity<CarrierDTO>(carrier, HttpStatus.OK);
	}
	
	/**
	 * Search carrier.
	 *
	 * @param carrierName the carrier name
	 * @return the response entity
	 */
	@RequestMapping(value = "/search/{carrierName}", method = RequestMethod.GET)
	public ResponseEntity<List<CarrierDTO>> searchCustomer(@PathVariable String carrierName) {
		List<CarrierDTO> carrierDTO = carrierService.fetchCarriersByName(carrierName);
		return new ResponseEntity<List<CarrierDTO>>(carrierDTO, HttpStatus.OK);
	}
	

}
