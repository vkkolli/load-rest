package com.cei.load.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class EquipmentDTO.
 */
@Getter
@Setter
public class EquipmentDTO {

	Long id;
	
	String equipmentName;
	
	String equipmentDescription;
	
	boolean isActive;
}
