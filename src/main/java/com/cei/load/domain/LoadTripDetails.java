package com.cei.load.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "load_trip_details", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_trip_details_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.load_trip_details_seq", allocationSize = 1)
@Getter
@Setter
public class LoadTripDetails extends Auditable<Long> {

	public enum TripTypes {ORGIN, DESTINATION, STOPOFF_PICKUP, STOPOFF_DELIVERY} ;

	@OneToOne
	@JoinColumn(name = "load_id")
	Load load;

	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	TripTypes tripType;

	@Column(name = "expected_trip_date")
	Date expectedTripDate;
	
	@Column(name = "expected_trip_time")
	Time expectedTripTime;

	@Column(name = "actual_trip_date")
	Date actualTripDate;

	@Column(name = "actual_trip_time")
	Time actualripTime;
	
	@Column(name = "company_name")
	String companyName;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state_abbr")
	String stateAbbr;
	
	@Column(name = "country_abbr")
	String countryAbbr;
	
	@Column(name = "zip_code")
	String zipCode;

	@Column(name ="is_active")
	boolean isActive;
	
	@Column(name = "trip_notes")
	String tripNotes;
}
