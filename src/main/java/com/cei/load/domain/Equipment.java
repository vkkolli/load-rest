package com.cei.load.domain;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;


/**
 * The Class Equipment.
 */
@Entity
@Table(name = "equipment", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "equipment_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.equipment_seq", allocationSize = 1)
@Getter
@Setter
public class Equipment extends Auditable<Long> {
	
	/** The equipment name. */
	@Column(name = "equipment_name")
	String equipmentName;
	
	/** The equipment description. */
	@Column(name = "equipment_description")
	String equipmentDescription;
	
	/** The is active. */
	@Column(name = "is_active")
	boolean isActive;
	
	@Column(name = "equipment_length")
	BigDecimal length;
	
	/** The weight. */
	@Column(name = "equipment_weight")
	BigDecimal weight;
}
