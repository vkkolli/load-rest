package com.cei.load.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class LoadDTO.
 */

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
	Set<LoadCommodityDTO> commodity = new LinkedHashSet<>();
	
	/** The load trips. */
	Set<LoadTripDetailsDTO> loadTrips = new LinkedHashSet<>();
	
	/** The length. */
	BigDecimal length;
	
	/** The weight. */
	BigDecimal weight;
}
