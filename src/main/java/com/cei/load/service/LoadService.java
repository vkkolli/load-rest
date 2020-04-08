package com.cei.load.service;

import java.util.List;

import com.cei.load.model.APIResponse;
import com.cei.load.model.LoadDTO;

public interface LoadService {
	
	APIResponse getAllActiveLoads();
	
	List<LoadDTO> getAllLoad();

	void save(LoadDTO load);
}
