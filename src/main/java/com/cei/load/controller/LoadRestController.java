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

import com.cei.load.model.LoadBoardDTO;
import com.cei.load.model.LoadCarrierDTO;
import com.cei.load.model.LoadDTO;
import com.cei.load.model.LookupDTO;
import com.cei.load.service.LoadBoardService;
import com.cei.load.service.LoadService;



/**
 * The Class LoadRestController.
 */
@RestController
@RequestMapping("/load")
public class LoadRestController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadRestController.class);

	/** The load service. */
	@Autowired
	LoadService loadService;

	/** The load board service. */
	@Autowired
	LoadBoardService loadBoardService;

	/**
	 * Gets the all active loads.
	 *
	 * @return the all active loads
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LoadBoardDTO>> getAllActiveLoads() {
		LOGGER.info("LoadRestController:: getAllActiveLoads-->");
		return new ResponseEntity<List<LoadBoardDTO>>(loadBoardService.findAllLoadsForLoadBoard(), HttpStatus.OK);

	}
	
	/**
	 * Save.
	 *
	 * @param load the load
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoadDTO> save(@RequestBody LoadDTO load){
		LoadDTO loadDto = loadService.save(load);
		return new ResponseEntity<LoadDTO>(loadDto, HttpStatus.OK);
	}
	
	/**
	 * Save.
	 *
	 * @param load the load
	 */
	@RequestMapping(value = "/{loadId}", method = RequestMethod.GET)
	public ResponseEntity<LoadDTO> edit(@PathVariable String loadId){
		LoadDTO load = loadService.getLoadById(Long.valueOf(loadId));
		return new ResponseEntity<LoadDTO>(load, HttpStatus.OK);
	}
	
	/**
	 * Equipment type.
	 *
	 * @return the response entity
	 */
	@RequestMapping(value = "/equipmentType", method = RequestMethod.GET)
	public ResponseEntity<List<LookupDTO>> equipmentType(){
		List<LookupDTO> activeEquipment = loadService.getActiveEquipment();
		return new ResponseEntity<List<LookupDTO>>(activeEquipment, HttpStatus.OK);
	}
	
	/**
	 * Assign carrier.
	 *
	 * @param loadCarrier the load carrier
	 * @return the response entity
	 */
	@RequestMapping(value="/assignCarrier", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> assignCarrier(@RequestBody LoadCarrierDTO loadCarrier){
		loadService.assignCarrier(loadCarrier);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
