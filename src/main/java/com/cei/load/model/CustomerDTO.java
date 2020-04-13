package com.cei.load.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class CustomerDTO.
 */
@Getter
@Setter
public class CustomerDTO {
	
	/** The id. */
	Long id;
	
	/** The company. */
	String company;
	
	/** The customer email. */
	String customerEmail;
	
	/** The is active. */
	boolean isActive;
}
