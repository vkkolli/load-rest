package com.cei.load.domain;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * The Class Load.
 */
@Entity
@Table(name = "load", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.load_seq", allocationSize = 1)

/**
 * Gets the weight.
 *
 * @return the weight
 */
@Getter

/**
 * Sets the weight.
 *
 * @param weight the new weight
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class Load extends Auditable<Long> {

	/** The load description. */
	@Column(name = "load_description")
	String loadDescription;

	/** The customer. */
	@OneToOne
	@JoinColumn(name = "customer_id")
	Customer customer;

	/** The customer address. */
	@OneToOne
	@JoinColumn(name = "customer_address_id")
	Address customerAddress;

	/** The load status. */
	@OneToOne
	@JoinColumn(name = "load_status_id")
	LoadStatus loadStatus;

	/** The carrier. */
	@OneToOne
	@JoinColumn(name = "carrier_id")
	Carrier carrier;

	/** The equipment. */
	@OneToOne
	@JoinColumn(name = "equipment_id")
	Equipment equipment;

	/** The total revenue. */
	@Column(name = "total_revenue")
	BigDecimal totalRevenue;

	/** The total cost. */
	@Column(name = "total_cost")
	BigDecimal totalCost;

	/** The max rate. */
	@Column(name = "max_rate")
	BigDecimal maxRate;

	/** The target rate. */
	@Column(name = "target_rate")
	BigDecimal targetRate;

	/** The load size. */
	@Column(name = "load_size")
	String loadSize;

	/** The trip mileage. */
	@Column(name = "trip_mileage")
	BigDecimal tripMileage;

	/** The load pricings. */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "load", orphanRemoval = true)
	@OrderBy("id ASC")
	Set<LoadPricing> loadPricings = new LinkedHashSet<>();

	/** The commodity. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "load", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<LoadCommodity> commodity = new LinkedHashSet<>();
	
	/** The load trips. */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "load", orphanRemoval = true)
	@OrderBy("id ASC")
	Set<LoadTripDetails> loadTrips = new LinkedHashSet<>();
	
	/** The length. */
	@Column(name = "equipment_length")
	BigDecimal length;
	
	/** The weight. */
	@Column(name = "equipment_weight")
	BigDecimal weight;
	
}
