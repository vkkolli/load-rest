package com.cei.load.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cei.load.model.CarrierDTO;
import com.cei.load.service.CarrierService;

/**
 * The Class CustomerRestController.
 */
@RestController
@RequestMapping("/carrier")
public class CarrierRestController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarrierRestController.class);
	
	/** The customer service. */
	@Autowired
	CarrierService carrierService;


	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarrierDTO>> getAllActiveCarriers() {
		LOGGER.info("CarrierRest Controller:: getAllActive Carriers-->");
		return new ResponseEntity<List<CarrierDTO>>(carrierService.findAll(), HttpStatus.OK);

	}
	
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
