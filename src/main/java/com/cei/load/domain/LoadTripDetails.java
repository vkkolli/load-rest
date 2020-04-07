package com.cei.load.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.IdentifiableBase;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "load_trip_details", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "load_trip_details_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.load_trip_details_seq", allocationSize = 1)
@Getter
@Setter
public class LoadTripDetails extends IdentifiableBase {
	
//	@Column(name = "load_id")
	@OneToOne
	@JoinColumn(name = "load_id")
	Load load; //fk
	
//	@Column(name = "trip_type_id")
	@OneToMany
	@JoinColumn(name = "trip_type_id")
	List<TripType> tripType; //fk
	
	@Column(name = "trip_date")
	Date tripDate;
	
	@Column(name = "trip_time")
	Time tripTime;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state_abbr")
	String stateAbbr;
	
	@Column(name = "country_abbr")
	String countryAbbr;
	
	@Column(name = "zip_code")
	String zipCode;
}
