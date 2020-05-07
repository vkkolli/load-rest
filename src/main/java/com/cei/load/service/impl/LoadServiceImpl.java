package com.cei.load.service.impl;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cei.load.domain.LoadTripDetails;
import com.cei.load.enums.TripTypes;
import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadBoardDTO;
import com.cei.load.model.LoadCarrierDTO;
import com.cei.load.model.LoadDTO;
import com.cei.load.model.LookupDTO;
import com.cei.load.model.PickupDeliveryDatesDTO;
import com.cei.load.model.SearchCriteriaDTO;
import com.cei.load.repository.LoadBoardRepository;
import com.cei.load.repository.LoadBoardSearchRepository;
import com.cei.load.repository.LoadTripDetailsRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cei.load.domain.Carrier;
import com.cei.load.domain.Load;
import com.cei.load.domain.LoadStatus;
import com.cei.load.repository.EquipmentRepository;
import com.cei.load.repository.LoadRepository;
import com.cei.load.repository.LoadStatusRepository;
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

	/** The equipment repository. */
	@Autowired
	EquipmentRepository equipmentRepository;
	
	/** The load status repository. */
	@Autowired
	LoadStatusRepository loadStatusRepository;

	/** The Load Trip Details Repository **/
	@Autowired
	LoadTripDetailsRepository loadTripDetailsRepository;

	@Autowired
	LoadBoardRepository loadBoardRepository;

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

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
	public LoadDTO save(LoadDTO load) {
		LOGGER.info("In save load");
		try {
			if (load.getCarrier().getId() == null) {
				load.setCarrier(null);
			}
			Load loadEntity = modelMapper.map(load, Load.class);
			LOGGER.info(loadEntity.toString());
			loadEntity = populateTripDetails(loadEntity);
			loadEntity = populatePricing(loadEntity);
			loadEntity = populateCommodity(loadEntity);
			loadEntity = loadRepository.save(loadEntity);
			LOGGER.info("load created id: {}", loadEntity.getId());
			return modelMapper.map(loadEntity, LoadDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Populate commodity.
	 *
	 * @param load the load
	 * @return the load
	 */
	private Load populateCommodity(Load load) {
		load.getCommodity().stream().forEach(commodity -> {
			commodity.setLoad(load);
		});
		return load;
	}

	/**
	 * Populate pricing.
	 *
	 * @param load the load
	 * @return the load
	 */
	private Load populatePricing(Load load) {
		load.getLoadPricings().stream().forEach(pricing -> {
			pricing.setLoad(load);
		});
		return load;
	}

	/**
	 * Populate trip details.
	 *
	 * @param load the load
	 * @return the load
	 */
	private Load populateTripDetails(Load load) {
		load.getLoadTrips().stream().forEach(trip -> {
			trip.setLoad(load);
			trip.setActive(true);
		});
		return load;
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

	/**
	 * Gets the active equipment.
	 *
	 * @return the active equipment
	 */
	@Override
	public List<LookupDTO> getActiveEquipment() {
		return modelMapper.map(equipmentRepository.getAllActiveEquipment(), modelMapperLookupDTOListType());
	}

	/**
	 * Model mapper lookup DTO list type.
	 *
	 * @return the type
	 */
	private Type modelMapperLookupDTOListType() {
		Type listType = new TypeToken<List<LookupDTO>>() {
		}.getType();

		return listType;
	}

	/**
	 * Assign carrier.
	 *
	 * @param loadCarrier the load carrier
	 */
	@Override
	public LoadDTO assignCarrier(LoadCarrierDTO loadCarrier) {
		LOGGER.info("Assign carrier for loadId: {}", loadCarrier.getLoadId());
		Optional<Load> loadOption = loadRepository.findById(loadCarrier.getLoadId());
		loadOption.ifPresent(l -> updateCarrier(l, loadCarrier));
		
		Load load = loadRepository.findById(loadCarrier.getLoadId()).get();
		return modelMapper.map(load, LoadDTO.class);
	}

	/**
	 * Update carrier.
	 *
	 * @param load        the load
	 * @param loadCarrier the load carrier
	 * @return the load
	 */
	private void updateCarrier(Load load, LoadCarrierDTO loadCarrier) {
		if (loadCarrier.isAssigned()) {
			LOGGER.info("Assign carrier for loadId {} and carrierId {}", loadCarrier.getLoadId(),
					loadCarrier.getCarrierId());
			load.setCarrier(new Carrier(loadCarrier.getCarrierId()));
			load.setLoadStatus(new LoadStatus(20L));
		} else {
			LOGGER.info("UnAssign carrier for loadId {} and carrierId {}", loadCarrier.getLoadId(),
					loadCarrier.getCarrierId());
			load.setCarrier(null);
			load.setLoadStatus(new LoadStatus(10L));
			unassignPickupDates(load);
		}
		loadRepository.save(load);

	}

	private void unassignPickupDates(Load load) {

		for(LoadTripDetails loadTripDetails: load.getLoadTrips()) {
			loadTripDetails.setActualTripDate(null);
			loadTripDetails.setActualripTime(null);
		}
	}

	/**
	 * Gets the all active load status.
	 *
	 * @return the all active load status
	 */
	@Override
	public List<LookupDTO> getAllActiveLoadStatus(){
		return modelMapper.map(loadStatusRepository.findAllActiveLoadStatus(), modelMapperLookupDTOListType());
	}

	@Override
	public LoadBoardDTO setPickupConfirmed(PickupDeliveryDatesDTO pickupDeliveryDatesDTO) throws ParseException {
		Date actualPickupDeliveryDate = dateFormat.parse(pickupDeliveryDatesDTO.getPickupOrDeliveryDate());
		Date actualPickupTDeliveryime = timeFormat.parse(pickupDeliveryDatesDTO.getPickupOrDeliveryTime());
		TripTypes tripType = pickupDeliveryDatesDTO.getTripType().equalsIgnoreCase("ORGIN")? TripTypes.ORGIN : TripTypes.DESTINATION;
		if(tripType.ordinal()==0) {
			loadTripDetailsRepository.updateActualPickupDates(actualPickupDeliveryDate, actualPickupTDeliveryime,
					pickupDeliveryDatesDTO.getLoadId());
		} else if(tripType.ordinal()==1){
			loadTripDetailsRepository.updateActualDeliveryDates(actualPickupDeliveryDate, actualPickupTDeliveryime,
					pickupDeliveryDatesDTO.getLoadId());
		}
		Load load = loadRepository.findById(pickupDeliveryDatesDTO.getLoadId()).get();
		Long loadStatusId = pickupDeliveryDatesDTO.getTripType().equalsIgnoreCase("ORGIN")? 30L : 40L;
		load.setLoadStatus(new LoadStatus(loadStatusId));
		loadRepository.save(load);
		SearchCriteriaDTO searchCarrierDto = new SearchCriteriaDTO();
		searchCarrierDto.setLoadId(load.getId());
		return loadBoardRepository.findLoadsByCriteria(searchCarrierDto).get(0);

	}
}
