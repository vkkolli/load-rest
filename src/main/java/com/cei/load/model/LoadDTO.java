package com.cei.load.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LoadDTO.
 */
@Getter
@Setter
public class LoadDTO {
	
	/** The id. */
	Long id;
	
	/** The load description. */
	String loadDescription;
	
	/** The customer. */
	CustomerDTO customer;
	
	/** The customer address. */
	AddressDTO customerAddress;
	
	/** The load status. */
	LoadStatusDTO loadStatus;
	
	/** The carrier. */
	CarrierDTO carrier;
	
	/** The equipment. */
	EquipmentDTO equipment;
	
	/** The total revenue. */
	BigDecimal totalRevenue;
	
	/** The total cost. */
	BigDecimal totalCost;
	
	/** The max revenue. */
	BigDecimal maxRevenue;
	
	/** The target. */
	BigDecimal target;
	
	/** The load type. */
	String loadType;
	
	/** The expected pickup date. */
	Date expectedPickupDate;
	
	/** The expected pickup time. */
	Time expectedPickupTime;
	
	/** The expected delivery date. */
	Date expectedDeliveryDate;
	
	/** The expected delivery time. */
	Time expectedDeliveryTime;
	
	/** The confirm pickup. */
	boolean confirmPickup;
	
	/** The confirm delivery. */
	boolean confirmDelivery;
}
