package com.cei.load.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadDTO {
	
	Long id;
	
	String loadDescription;
	
	CustomerDTO customer;
	
	AddressDTO customerAddress;
	
	LoadStatusDTO loadStatus;
	
	CarrierDTO carrier;
	
	EquipmentDTO equipment;
	
	BigDecimal totalRevenue;
	
	BigDecimal totalCost;
	
	BigDecimal maxRevenue;
	
	BigDecimal target;
	
	String loadType;
	
	Date expectedPickupDate;
	
	Time expectedPickupTime;
	
	Date expectedDeliveryDate;
	
	Time expectedDeliveryTime;
	
	boolean confirmPickup;
	
	boolean confirmDelivery;
}
