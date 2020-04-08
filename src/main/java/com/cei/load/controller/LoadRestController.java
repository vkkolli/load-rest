package com.cei.load.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadDTO;
import com.cei.load.model.LoadDTO;
import com.cei.load.service.LoadService;



@RestController
@RequestMapping("/load")
public class LoadRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadRestController.class);

	@Autowired
	LoadService loadService;

	@RequestMapping(value = "/activeLoads", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponse getAllActiveLoads(@RequestBody LoadDTO loadDto) {
		LOGGER.info("LoadRestController:: getAllActiveLoads-->");
		return loadService.getAllActiveLoads();
	}

	@RequestMapping("/")
	public ResponseEntity<List<LoadDTO>> get() {
		List<LoadDTO> allLoad = loadService.getAllLoad();
		return new ResponseEntity<List<LoadDTO>>(allLoad, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody LoadDTO load){
		loadService.save(load);
	}

}
