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
@Table(name = "load", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "load_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.load_seq", allocationSize = 1)
@Getter
@Setter
public class Load extends Auditable<Long> {

	@Column(name = "load_description")
	String loadDescription;
	
//	@Column(name = "customer_id")
	@OneToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
//	@Column(name = "customer_address_id")
	@OneToOne
	@JoinColumn(name = "customer_address_id")
	Address customerAddress;
	
//	@Column(name = "load_status_id")
	@OneToOne
	@JoinColumn(name = "load_status_id")
	LoadStatus loadStatus;
	
//	@Column(name = "carrier_id")
	@OneToOne
	@JoinColumn(name = "carrier_id")
	Carrier carrier;
	
//	@Column(name = "equipment_id")
	@OneToOne
	@JoinColumn(name = "equipment_id")
	Equipment equipment;
	
	@Column(name = "total_revenue")
	BigDecimal totalRevenue;
	
	@Column(name = "total_cost")
	BigDecimal totalCost;
	
	@Column(name = "max_revenue")
	BigDecimal maxRevenue;
	
	@Column(name = "target")
	BigDecimal target;
	
	@Column(name = "load_type")
	String loadType;
	
	@Column(name = "expected_pickup_date")
	Date expectedPickupDate;
	
	@Column(name = "expected_pickup_time")
	Time expectedPickupTime;
	
	@Column(name = "expected_delivery_date")
	Date expectedDeliveryDate;
	
	@Column(name = "expected_delivery_time")
	Time expectedDeliveryTime;
	
	@Column(name = "confirm_pickup")
	boolean confirmPickup;
	
	@Column(name = "confirm_delivery")
	boolean confirmDelivery;
	
}
