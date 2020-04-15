package com.cei.load.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

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
	
	/** The max rate. */
	BigDecimal maxRate;
	
	/** The target rate. */
	BigDecimal targetRate;
	
	/** The load size. */
	String loadSize;
	
	/** The trip mileage. */
	BigDecimal tripMileage;
	
	/** The load pricings. */
	Set<LoadPricingDTO> loadPricings = new LinkedHashSet<>();
	
	/** The load commodity DTO. */
	LoadCommodityDTO commodity;
	
	/** The load trips. */
	Set<LoadTripDetailsDTO> loadTrips = new LinkedHashSet<>();
}
