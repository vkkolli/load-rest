package com.cei.load.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;

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
	private TripTypes tripType;

	@Column(name = "expected_trip_date")
	Date expectedTripDate;
	
	@Column(name = "expected_trip_time")
	Time expectedTripTime;

	@Column(name = "actual_trip_date")
	Date actualTripDate;

	@Column(name = "actual_trip_time")
	Time actualripTime;
	
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
}
