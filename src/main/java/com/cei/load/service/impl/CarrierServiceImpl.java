package com.cei.load.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cei.load.domain.Carrier;
import com.cei.load.model.CarrierDTO;
import com.cei.load.repository.CarrierRepository;
import com.cei.load.service.CarrierService;

/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CarrierServiceImpl implements CarrierService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarrierServiceImpl.class);

	/** The carrier repo. */
	@Autowired
	CarrierRepository carrierRepository;

	/** The model maper. */
	@Autowired
	ModelMapper modelMaper;
	

	/**
	 * Save.
	 *
	 * @param carrier the carrier
	 * @return the carrier DTO
	 */
	@Override
	public CarrierDTO save(CarrierDTO carrier) {
		LOGGER.info("Saving carrier");
		Carrier carrierEntity = modelMaper.map(carrier, Carrier.class);
		carrier = modelMaper.map(carrierRepository.save(carrierEntity), CarrierDTO.class);
		return carrier;
	}

	/**
	 * Fetch customer by id.
	 *
	 * @param carrierId the carrier id
	 * @return the carrier DTO
	 */
	@Override
	public CarrierDTO fetchCarrierById(Long carrierId) {
		LOGGER.info("Fetching carrier for id : {}", carrierId);
		Optional<Carrier> carrierEntity = carrierRepository.findById(carrierId);
		CarrierDTO carrierDTO =  modelMaper.map(carrierEntity.get(), CarrierDTO.class);
		carrierDTO.setCityStateZip();
		return carrierDTO;
	}

	/**
	 * Fetch carrier by name.
	 *
	 * @param carrierName the carrier name
	 * @return the list
	 */
	@Override
	public List<CarrierDTO> fetchCarriersByName(String carrierName) {
		List<Carrier> carriers = carrierRepository.findAllCarrierByCarrierName("%" +carrierName+"%");
		List<CarrierDTO> carrierDTOs = modelMaper.map(carriers, modelMapperCarrierDTOListType());
		for(CarrierDTO carrierDTO : carrierDTOs) {
			carrierDTO.setCityStateZip();
		}
		return carrierDTOs;
	}

	@Override
	public List<CarrierDTO> findAll() {
		List<Carrier> carriers = carrierRepository.findAll();
		List<CarrierDTO> carrierDTOs = modelMaper.map(carriers, modelMapperCarrierDTOListType());
		for(CarrierDTO carrierDTO : carrierDTOs) {
			carrierDTO.setCityStateZip();
		}
		return carrierDTOs;
	}

	/**
	 * Model mapper lookup DTO list type.
	 *
	 * @return the type
	 */
	private Type modelMapperCarrierDTOListType() {
		Type listType = new TypeToken<List<CarrierDTO>>() {
		}.getType();

		return listType;
	}
	
	

}
