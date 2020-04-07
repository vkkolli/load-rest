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
@Table(name = "addresses", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.addresses_seq", allocationSize = 1)
@Getter
@Setter
public class Address extends IdentifiableBase{
	
	@Column(name = "addr_line1")
	String addressLine1;
	
	@Column(name = "addr_line2")
	String addressLine2;
	
	@Column(name = "customer_id")
	Long customer;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state_abbr")
	String stateAbbr;
	
	@Column(name = "country_abbr")
	String countryAbbr;
	
	@Column(name = "zipcode")
	String zipcode;
	
	@Column(name = "contact_person")
	String contactPerson;
	
	@Column(name = "email_id")
	String emailId;
	
	@Column(name = "phone_no")
	String phoneNo;
}
