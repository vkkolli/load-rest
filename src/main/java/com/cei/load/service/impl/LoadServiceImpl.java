package com.cei.load.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import com.cei.load.domain.Load;
import com.cei.load.model.APIResponse;

import com.cei.load.model.LoadDTO;
import com.cei.load.repository.LoadRepository;
import com.cei.load.service.LoadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


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
        apiResponse.setLoads(activeLoads.stream().map(type -> modelMapper.map(type, LoadDTO.class)).collect(Collectors.toList()));
        return apiResponse;

    }


}
