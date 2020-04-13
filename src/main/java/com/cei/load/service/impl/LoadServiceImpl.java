package com.cei.load.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cei.load.domain.Load;
import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadDTO;
import com.cei.load.repository.LoadRepository;
import com.cei.load.service.LoadService;

/**
 * The Class LoadServiceImpl.
 */
@Service
public class LoadServiceImpl implements LoadService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadServiceImpl.class);

	/** The load repository. */
	@Autowired
	LoadRepository loadRepository;

	/** The model mapper. */
	@Autowired
	ModelMapper modelMapper;

	/** The api response. */
	@Autowired
	APIResponse apiResponse;

	/**
	 * Gets the all active loads.
	 *
	 * @return the all active loads
	 */
	@Override
	public APIResponse getAllActiveLoads() {
		List<Load> activeLoads = loadRepository.findAll();
		apiResponse = new APIResponse();
		apiResponse.setLoads(
				activeLoads.stream().map(type -> modelMapper.map(type, LoadDTO.class)).collect(Collectors.toList()));
		return apiResponse;
	}

	/**
	 * Gets the all load.
	 *
	 * @return the all load
	 */
	@Override
	public List<LoadDTO> getAllLoad() {
		List<Load> loadList = loadRepository.findAll();
		Type listType = new TypeToken<List<LoadDTO>>() {
		}.getType();
		List<LoadDTO> loads = modelMapper.map(loadList, listType);
		return loads;
	}

	/**
	 * Save.
	 *
	 * @param load the load
	 */
	@Override
	public void save(LoadDTO load) {
		LOGGER.info("In save load");
		try {
			Load loadEntity = modelMapper.map(load, Load.class);
			loadEntity = loadRepository.save(loadEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("load created id: {}", load.getId());
	}
	
	/**
	 * Gets the load by id.
	 *
	 * @param loadId the load id
	 * @return the load by id
	 */
	@Override
	public LoadDTO getLoadById(Long loadId) {
		Load load = loadRepository.findById(loadId).get();
		return modelMapper.map(load, LoadDTO.class);
	}
}
