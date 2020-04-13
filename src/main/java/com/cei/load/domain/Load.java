package com.cei.load.domain;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Load.
 */
@Entity
@Table(name = "load", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.load_seq", allocationSize = 1)
@Getter
@Setter
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
	@Column(name="trip_mileage")
	BigDecimal tripMileage;

	
}
