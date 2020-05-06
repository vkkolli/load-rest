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
	private BigDecimal equipmentLength;

	/** The equipment Weight. */
	private BigDecimal equipmentWeight;
	
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

	private Boolean isConfirmPickupEnable;

	private Boolean isConfirmDeliveryEnable;


	public LoadBoardDTO(Long load_id, String age_of_load, String equipment_name, String equipment_description,BigDecimal equipment_length,
						BigDecimal equipment_weight,String load_type,
						String load_status, 	String customer_name, String customer_email, String customer_phone,
						String customer_address,  BigDecimal mileage, String origin_csz, String pickup_date,
						String destination_csz, String delivery_date, String commodity_name, String commodity_weight,
						String commodity_length, BigDecimal commodity_value, 	String revenue_cost, String carrier_name,
						String carrier_contact, String carrier_email, String carrier_phone, String carrier_address,
						String actual_pickup_date, String actual_delivery_date, Boolean is_confirm_pickup_enable, Boolean is_confirm_delivery_enable) {
		this.loadId = load_id;
		this.age = age_of_load;
		this.equipmentName = equipment_name;
		this.equipmentDesc = equipment_description;
		this.equipmentLength = equipment_length;
		this.equipmentWeight = equipment_weight;
		this.loadType = load_type;
		this.loadStatus = load_status;
		this.customerName = customer_name;
		this.customerEmail = customer_email;
		this.customerPhone = customer_phone;
		this.customerAddress = customer_address;
		this.mileage = mileage;
		this.originCsz = origin_csz;
		this.pickupDate = pickup_date;
		this.destinationCsz = destination_csz;
		this.deliveryDate = delivery_date;
		this.commodityName = commodity_name;
		this.commodityWeight = commodity_weight;
		this.commodityLength = commodity_length;
		this.commodityValue = commodity_value;
		this.revenueCost = revenue_cost;
		this.carrierName = carrier_name;
		this.carrierContact = carrier_contact;
		this.carrierEmail = carrier_email;
		this.carrierPhone = carrier_phone;
		this.carrierAddress = carrier_address;
		this.actualPickupDate = actual_pickup_date;
		this.actualDeliveryDate = actual_delivery_date;
		this.isConfirmPickupEnable = is_confirm_pickup_enable;
		this.isConfirmDeliveryEnable = is_confirm_delivery_enable;
	}
}
