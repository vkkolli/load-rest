package com.cei.load.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class AddressDTO.
 */
@Getter 
@Setter
public class AddressDTO {

	/** The id. */
	Long id;
	
	/** The address line 1. */
	String addressLine1;
	
	/** The address line 2. */
	String addressLine2;
	
	/** The customer. */
	Long customer;
	
	/** The city. */
	String city;
	
	/** The state abbr. */
	String stateAbbr;
	
	/** The country abbr. */
	String countryAbbr;
	
	/** The zipcode. */
	String zipcode;
	
	/** The contact person. */
	String contactPerson;
	
	/** The email id. */
	String emailId;
	
	/** The phone no. */
	String phoneNo;
}
