package com.cei.load.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse {
	private int status;
	

	
	private List<LoadDAO> loads;
	

	public APIResponse() {
		if (loads == null)
			loads = new ArrayList<>();
	}
}
