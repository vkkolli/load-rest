package com.cei.load.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.IdentifiableBase;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "us_zip", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "us_zip_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.us_zip_seq", allocationSize = 1)
@Getter
@Setter
public class Zipcode extends IdentifiableBase {
	
	@Column(name = "zipcode")
	String zipcode;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state")
	String state;
	
	@Column(name = "state_abbr")
	char stateAbbr;
	
	@Column(name = "county_area")
	String countryArea;
	
	@Column(name = "code")
	char code;
	
	@Column(name = "latitude")
	Double latitude;
	
	@Column(name = "longitude")
	Double longitude;
	
	@Column(name = "country")
	String country;
	
	@Column(name = "country_abbr")
	String countryAbbr;
}
