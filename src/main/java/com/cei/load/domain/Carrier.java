package com.cei.load.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The Class Carrier.
 */
@Entity
@Table(name = "carrier", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "carrier_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.carrier_seq", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
public class Carrier extends Auditable<Long> {
	
	/** The carrier name. */
	@Column(name = "carrier_name")
	String carrierName;
	
	/** The carrier contact. */
	@Column(name = "carrier_contact")
	String carrierContact;
	
	/** The email id. */
	@Column(name = "email_id")
	String emailId;
	
	/** The phone. */
	@Column(name = "phone")
	String phone;
	
	/** The is active. */
	@Column(name = "is_active")
	boolean isActive;
	
	/** The city. */
	@Column(name = "city")
	String city;
	
	/** The state abbr. */
	@Column(name = "state_abbr")
	String stateAbbr;
	
	/** The country abbr. */
	@Column(name = "country_abbr")
	String countryAbbr;
	
	/** The zip. */
	@Column(name = "zip")
	String zip;
	
	public Carrier(Long id) {
		setId(id);
	}
}
