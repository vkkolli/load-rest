package com.cei.load.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class EquipmentDTO.
 */
@Getter
@Setter
public class EquipmentDTO {

	/** The id. */
	Long id;
	
	/** The equipment name. */
	String equipmentName;
	
	/** The equipment description. */
	String equipmentDescription;
	
	/** The is active. */
	boolean isActive;
	
	/** The length. */
	BigDecimal length;
	
	/** The weight. */
	BigDecimal weight;
}
