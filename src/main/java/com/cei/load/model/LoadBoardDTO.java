package com.cei.load.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@ToString
public class LoadBoardDTO {
	
	private Long loadId;
	private String age;
	private String equipmentName;
	private String  loadType;
	private String  loadStatus;
	private String customerName;
	private String customerEmail;
	private BigDecimal mileage;
	private String originCsz;
	private String pickupDate;
	private String destinationCsz;
	private String deliveryDate;
	private String commodityName;
	private String commodityWeight;
	private String commodityLength;
	private String revenueCost;
	private String carrierName;
	private String actualPickupDate;
	private String actualDeliveryDate;

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
