package com.cei.load.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class CarrierDTO.
 */
@Getter
@Setter
public class CarrierDTO {

	/** The id. */
	Long id;
	
	/** The carrier name. */
	String carrierName;

	/** The carrier contact. */
	String carrierContact;
	
	/** The email id. */
	String emailId;
	
	/** The phone. */
	String phone;
	
	/** The is active. */
	boolean isActive;
	
	/** The city. */
	String city;
	
	/** The state abbr. */
	String stateAbbr;
	
	/** The country abbr. */
	String countryAbbr;
	
	/** The zip. */
	String zip;

    String cityStateZip;

    public void setCityStateZip () {
        this.cityStateZip = this.city + ", " + this.stateAbbr + ", " + this.zip;
    }

}
