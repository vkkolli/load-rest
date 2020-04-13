package com.cei.load.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;


/**
 * The Class ZipcodeSearchDTO.
 */
@Getter
@Setter
public class ZipcodeSearchDTO {
	
	/** The id. */
	Long id;
	
	/** The zipcode. */
	String zipcode;

	/** The city. */
	String city;

	/** The state name. */
	String stateName;

	/** The state abbr. */
	char stateAbbr;

	/** The country area. */
	String countryArea;

	/** The country code. */
	char countryCode;

	/** The latitude. */
	Double latitude;

	/** The longitude. */
	Double longitude;

	/** The country. */
	String country;

	/** The country abbr. */
	String countryAbbr;

	/** The full address. */
	private String fullAddress;
	
	/**
	 * Instantiates a new zipcode search DTO.
	 *
	 * @param id the id
	 * @param zipcode the zipcode
	 * @param city the city
	 * @param stateName the state name
	 * @param stateAbbr the state abbr
	 * @param countryArea the country area
	 * @param countryCode the country code
	 * @param country the country
	 * @param countryAbbr the country abbr
	 */
	public ZipcodeSearchDTO(Long id, String zipcode, String city, String stateName, char stateAbbr, String countryArea, char countryCode, String country, String countryAbbr ) {
		this.id = id;
		this.zipcode = zipcode;
		this.city = city;
		this.stateName = stateName;
		this.stateAbbr = stateAbbr;
		this.countryArea = countryArea;
		this.countryCode = countryCode;
		this.country = country;
		this.countryAbbr = countryAbbr;
	}
	
	/**
	 * Gets the full address.
	 *
	 * @return the full address
	 */
	public String getFullAddress() {
	    this
	      .fullAddress = Stream.<CharSequence>of((CharSequence[])new String[] { getCity(), getStateName(), getZipcode() }).filter(s -> (s != null)).collect(Collectors.joining(", "));
	    return this.fullAddress;
	  }
}
