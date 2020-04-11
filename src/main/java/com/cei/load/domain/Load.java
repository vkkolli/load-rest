package com.cei.load.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

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

@Entity
@Table(name = "load", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.load_seq", allocationSize = 1)
@Getter
@Setter
public class Load extends Auditable<Long> {

	@Column(name = "load_description")
	String loadDescription;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@OneToOne
	@JoinColumn(name = "customer_address_id")
	Address customerAddress;
	
	@OneToOne
	@JoinColumn(name = "load_status_id")
	LoadStatus loadStatus;
	
	@OneToOne
	@JoinColumn(name = "carrier_id")
	Carrier carrier;
	
	@OneToOne
	@JoinColumn(name = "equipment_id")
	Equipment equipment;
	
	@Column(name = "total_revenue")
	BigDecimal totalRevenue;
	
	@Column(name = "total_cost")
	BigDecimal totalCost;
	
	@Column(name = "max_rate")
	BigDecimal maxRate;
	
	@Column(name = "target_rate")
	BigDecimal targetRate;
	
	@Column(name = "load_size")
	String loadSize;
	
	@Column(name="trip_mileage")
	BigDecimal tripMileage;

	
}
