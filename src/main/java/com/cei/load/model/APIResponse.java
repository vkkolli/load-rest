package com.cei.load.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


/**
 * The Class APIResponse.
 */
@Getter
@Setter
@Component
public class APIResponse {
	
	/** The status. */
	private int status;
	

	
	/** The loads. */
	private List<LoadDTO> loads;
	

	/**
	 * Instantiates a new API response.
	 */
	public APIResponse() {
		if (loads == null)
			loads = new ArrayList<>();
	}
}
