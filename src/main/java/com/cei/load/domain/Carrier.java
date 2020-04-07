package com.cei.load.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carrier", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "carrier_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.carrier_seq", allocationSize = 1)
@Getter
@Setter
public class Carrier extends Auditable<Long> {
	
	@Column(name = "carrier_name")
	String carrierName;
	
	@Column(name = "equipment_id") //fk
	Long equipment;
	
	@Column(name = "carrier_contact")
	String carrierContact;
	
	@Column(name = "email_id")
	String emailId;
	
	@Column(name = "phone")
	String phone;
	
	@Column(name = "is_active")
	boolean isActive;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state_abbr")
	String stateAbbr;
	
	@Column(name = "country_abbr")
	String countryAbbr;
	
	@Column(name = "zip")
	String zip;
	
}
