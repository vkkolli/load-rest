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

	/** The equipment Description. */
	private String equipmentDesc;

	/** The equipment Length. */
	private String equipmentLength;

	/** The equipment Weight. */
	private String equipmentWeight;
	
	/** The load type. */
	private String  loadType;
	
	/** The load status. */
	private String  loadStatus;
	
	/** The customer name. */
	private String customerName;
	
	/** The customer email. */
	private String customerEmail;

	/** The customer phone. */
	private String customerPhone;

	/** The customer address. */
	private String customerAddress;
	
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

	/** The commodity value. */
	private BigDecimal commodityValue;
	
	/** The revenue cost. */
	private String revenueCost;
	
	/** The carrier name. */
	private String carrierName;

	/** The carrier contact. */
	private String carrierContact;

	/** The carrier email. */
	private String carrierEmail;

	/** The carrier phone. */
	private String carrierPhone;

	/** The carrier address. */
	private String carrierAddress;
	
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
	public LoadBoardDTO(Long loadId, String age, String equipmentName, String equipmentDesc,String equipmentLength,
						String equipmentWeight,String loadType,
						String loadStatus, 	String customerName, String customerEmail, String customerPhone,
						String customerAddress,  BigDecimal mileage, String originCsz, String pickupDate,
						String destinationCsz, String deliveryDate, String commodityName, String commodityWeight,
						String commodityLength, BigDecimal commodityValue, 	String revenueCost, String carrierName,
						String carrierContact, String carrierEmail, String carrierPhone, String carrierAddress,
						String actualPickupDate, String actualDeliveryDate) {
		this.loadId = loadId;
		this.age = age;
		this.equipmentName = equipmentName;
		this.equipmentDesc = equipmentDesc;
		this.equipmentLength = equipmentLength;
		this.equipmentWeight = equipmentWeight;
		this.loadType = loadType;
		this.loadStatus = loadStatus;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.mileage = mileage;
		this.originCsz = originCsz.trim();
		this.pickupDate = pickupDate.trim();
		this.destinationCsz = destinationCsz.trim();
		this.deliveryDate = deliveryDate.trim();
		this.commodityName = commodityName;
		this.commodityWeight = commodityWeight;
		this.commodityLength = commodityLength;
		this.commodityValue = commodityValue;
		this.revenueCost = revenueCost;
		this.carrierName = carrierName;
		this.carrierContact = carrierContact;
		this.carrierEmail = carrierEmail;
		this.carrierPhone = carrierPhone;
		this.carrierAddress = carrierAddress;
		this.actualPickupDate = actualPickupDate.trim();
		this.actualDeliveryDate = actualDeliveryDate.trim();
	}
}
