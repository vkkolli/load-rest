package com.cei.load.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.cei.load.domain.vo.Auditable;
import com.cei.load.enums.TripTypes;
import com.cei.load.util.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LoadTripDetails.
 */
@Entity
@Table(name = "load_trip_details", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_trip_details_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.load_trip_details_seq", allocationSize = 1)
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@Getter
@Setter
public class LoadTripDetails extends Auditable<Long> {

	/** The load. */
	@OneToOne
	@JoinColumn(name = "load_id")
	Load load;

	/** The trip type. */
	@Enumerated(EnumType.STRING)
	@Column(name = "trip_type", columnDefinition = "trip_types")
	@Type(type = "pgsql_enum")
	TripTypes tripType;

	/** The expected trip date. */
	@Temporal(TemporalType.DATE)
	@JsonDeserialize(using = DateConverter.DateDeserialize.class)
	@JsonSerialize(using = DateConverter.DateSerialize.class)
	@Column(name = "expected_trip_date")
	Date expectedTripDate;

	/** The expected trip time. */
	@Temporal(TemporalType.TIME)
	@JsonDeserialize(using = DateConverter.DateDeserialize.class)
	@JsonSerialize(using = DateConverter.DateSerialize.class)
	@Column(name = "expected_trip_time")
	Date expectedTripTime;

	/** The actual trip date. */
	@Temporal(TemporalType.DATE)
	@JsonDeserialize(using = DateConverter.DateDeserialize.class)
	@JsonSerialize(using = DateConverter.DateSerialize.class)
	@Column(name = "actual_trip_date")
	Date actualTripDate;

	/** The actualrip time. */
	@Temporal(TemporalType.TIME)
	@JsonDeserialize(using = DateConverter.DateDeserialize.class)
	@JsonSerialize(using = DateConverter.DateSerialize.class)
	@Column(name = "actual_trip_time")
	Date actualripTime;

	/** The company name. */
	@Column(name = "company_name")
	String companyName;

	/** The city. */
	@Column(name = "city")
	String city;

	/** The state abbr. */
	@Column(name = "state_abbr")
	String stateAbbr;

	/** The country abbr. */
	@Column(name = "country_abbr")
	String countryAbbr;

	/** The zip code. */
	@Column(name = "zip_code")
	String zipCode;

	/** The is active. */
	@Column(name = "is_active")
	boolean isActive;

	/** The trip notes. */
	@Column(name = "trip_notes")
	String tripNotes;
}
