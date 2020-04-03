package com.cei.load.controller;

import java.util.List;

import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadDTO;
import com.cei.load.service.LoadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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



}
