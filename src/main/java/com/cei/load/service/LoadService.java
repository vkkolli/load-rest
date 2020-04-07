package com.cei.load.service;

import java.util.List;

import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadDAO;

public interface LoadService {
	
	APIResponse getAllActiveLoads();
	
	List<LoadDAO> getAllLoad();

	LoadDAO save();
}
