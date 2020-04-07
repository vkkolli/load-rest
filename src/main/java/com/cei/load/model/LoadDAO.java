package com.cei.load.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadDAO {
	
	Long id;
	
	String loadDescription;
	
	CustomerDAO customer;
	
	AddressDAO customerAddress;
	
	LoadStatusDAO loadStatus;
	
	CarrierDAO carrier;
	
	EquipmentDAO equipment;
	
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
