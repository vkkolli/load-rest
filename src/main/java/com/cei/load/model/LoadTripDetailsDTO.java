/*
 * 
 */
package com.cei.load.model;


import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cei.load.enums.TripTypes;
import com.cei.load.util.DateConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LoadTripDetailsDTO.
 */
@Getter
@Setter
@JsonIgnoreType
public class LoadTripDetailsDTO {

	/** The id. */
	Long id;

	/** The trip types. */
	@Enumerated(EnumType.STRING)
	TripTypes tripType;

	/** The expected trip date. */
	@JsonDeserialize(using = DateConverter.DateDeserialize.class)
	@JsonSerialize(using = DateConverter.DateSerialize.class)
	Date expectedTripDate;

	/** The expected trip time. */
	@Temporal(TemporalType.TIME)
	@JsonDeserialize(using = DateConverter.DateTimeDeserialize.class)
	@JsonSerialize(using = DateConverter.DateTimeSerialize.class)
	Date expectedTripTime;

	/** The actual trip date. */
	@JsonDeserialize(using = DateConverter.DateDeserialize.class)
	@JsonSerialize(using = DateConverter.DateSerialize.class)
	Date actualTripDate;

	/** The actualrip time. */
	@Temporal(TemporalType.TIME)
	@JsonDeserialize(using = DateConverter.DateTimeDeserialize.class)
	@JsonSerialize(using = DateConverter.DateTimeSerialize.class)
	Date actualTripTime;

	/** The company name. */
	String companyName;

	/** The city. */
	String city;

	/** The state abbr. */
	String stateAbbr;

	/** The country abbr. */
	String countryAbbr;

	/** The zip code. */
	String zipCode;

	/** The is active. */
	boolean isActive;

	/** The trip notes. */
	String tripNotes;

}
