package com.cei.load.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cei.load.domain.Load;
import com.cei.load.model.APIResponse;
import com.cei.load.model.AddressDAO;
import com.cei.load.model.CarrierDAO;
import com.cei.load.model.CustomerDAO;
import com.cei.load.model.EquipmentDAO;
import com.cei.load.model.LoadDAO;
import com.cei.load.model.LoadStatusDAO;
import com.cei.load.repository.LoadRepository;
import com.cei.load.service.LoadService;


@Service
public class LoadServiceImpl implements LoadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadServiceImpl.class);

    @Autowired
    LoadRepository loadRepository;


    @Autowired
    ModelMapper modelMapper;


    @Autowired
    APIResponse apiResponse;


    @Override
    public APIResponse getAllActiveLoads() {

        List<Load> activeLoads = loadRepository.findAllActiveLoads();
        apiResponse = new APIResponse();
        apiResponse.setLoads(activeLoads.stream().map(type -> modelMapper.map(type, LoadDAO.class)).collect(Collectors.toList()));
        return apiResponse;

    }

    @Override
	public List<LoadDAO> getAllLoad() {
		List<LoadDAO> loadList = new ArrayList<>();
		LoadDAO l = new LoadDAO();
		l.setCarrier(new CarrierDAO());
		l.setCustomer(new CustomerDAO());
		l.setConfirmDelivery(Boolean.FALSE);
		l.setConfirmPickup(Boolean.TRUE);
		l.setCustomerAddress(new AddressDAO());
		l.setEquipment(new EquipmentDAO());
		l.setLoadDescription("Load description");
		l.setLoadStatus(new LoadStatusDAO());
		l.setLoadType("Full");
		l.setMaxRevenue(new BigDecimal("1000"));
		l.setTarget(new BigDecimal("500"));
		loadList.add(l);
		return loadList;
	}

	@Override
	public LoadDAO save() {
		return null;
	}


}
