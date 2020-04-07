package com.cei.load.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class APIResponse {
	private int status;
	

	
	private List<LoadDAO> loads;
	

	public APIResponse() {
		if (loads == null)
			loads = new ArrayList<>();
	}
}
