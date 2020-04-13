package com.cei.load.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class LoadBoardDTO.
 */
@Getter
@Setter
@ToString
public class LoadBoardDTO {
	
	/** The load id. */
	private Long loadId;
	
	/** The age. */
	private String age;
	
	/** The equipment name. */
	private String equipmentName;
	
	/** The load type. */
	private String  loadType;
	
	/** The load status. */
	private String  loadStatus;
	
	/** The customer name. */
	private String customerName;
	
	/** The customer email. */
	private String customerEmail;
	
	/** The mileage. */
	private BigDecimal mileage;
	
	/** The origin csz. */
	private String originCsz;
	
	/** The pickup date. */
	private String pickupDate;
	
	/** The destination csz. */
	private String destinationCsz;
	
	/** The delivery date. */
	private String deliveryDate;
	
	/** The commodity name. */
	private String commodityName;
	
	/** The commodity weight. */
	private String commodityWeight;
	
	/** The commodity length. */
	private String commodityLength;
	
	/** The revenue cost. */
	private String revenueCost;
	
	/** The carrier name. */
	private String carrierName;
	
	/** The actual pickup date. */
	private String actualPickupDate;
	
	/** The actual delivery date. */
	private String actualDeliveryDate;

	/**
	 * Instantiates a new load board DTO.
	 *
	 * @param loadId the load id
	 * @param age the age
	 * @param equipmentName the equipment name
	 * @param loadType the load type
	 * @param loadStatus the load status
	 * @param customerName the customer name
	 * @param customerEmail the customer email
	 * @param mileage the mileage
	 * @param originCsz the origin csz
	 * @param pickupDate the pickup date
	 * @param destinationCsz the destination csz
	 * @param deliveryDate the delivery date
	 * @param commodityName the commodity name
	 * @param commodityWeight the commodity weight
	 * @param commodityLength the commodity length
	 * @param revenueCost the revenue cost
	 * @param carrierName the carrier name
	 * @param actualPickupDate the actual pickup date
	 * @param actualDeliveryDate the actual delivery date
	 */
	public LoadBoardDTO(Long loadId, String age, String equipmentName, String loadType,  String loadStatus,
						String customerName, String customerEmail,
						BigDecimal mileage, String originCsz, String pickupDate,
						String destinationCsz, String deliveryDate,
						String commodityName, String commodityWeight, String commodityLength,
						String revenueCost, String carrierName, String actualPickupDate, String actualDeliveryDate) {
		this.loadId = loadId;
		this.age = age;
		this.equipmentName = equipmentName;
		this.loadType = loadType;
		this.loadStatus = loadStatus;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.mileage = mileage;
		this.originCsz = originCsz;
		this.pickupDate = pickupDate;
		this.destinationCsz = destinationCsz;
		this.deliveryDate = deliveryDate;
		this.commodityName = commodityName;
		this.commodityWeight = commodityWeight;
		this.commodityLength = commodityLength;
		this.revenueCost = revenueCost;
		this.carrierName = carrierName;
		this.actualPickupDate = actualPickupDate;
		this.actualDeliveryDate = actualDeliveryDate;
	}
}
