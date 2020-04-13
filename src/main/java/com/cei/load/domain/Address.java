package com.cei.load.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;


/**
 * The Class Address.
 */
@Entity
@Table(name = "addresses", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.addresses_seq", allocationSize = 1)
@Getter
@Setter
public class Address extends Auditable<Long>{
	
	/** The address line 1. */
	@Column(name = "addr_line1")
	String addressLine1;
	
	/** The address line 2. */
	@Column(name = "addr_line2")
	String addressLine2;
	
	/** The customer. */
	@Column(name = "customer_id")
	Long customer;
	
	/** The city. */
	@Column(name = "city")
	String city;
	
	/** The state abbr. */
	@Column(name = "state_abbr")
	String stateAbbr;
	
	/** The country abbr. */
	@Column(name = "country_abbr")
	String countryAbbr;
	
	/** The zipcode. */
	@Column(name = "zipcode")
	String zipcode;
	
	/** The contact person. */
	@Column(name = "contact_person")
	String contactPerson;
	
	/** The email id. */
	@Column(name = "email_id")
	String emailId;
	
	/** The phone no. */
	@Column(name = "phone_no")
	String phoneNo;

	/** The is active. */
	@Column(name = "is_active")
	boolean isActive;
}
