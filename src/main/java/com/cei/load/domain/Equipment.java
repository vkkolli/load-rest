package com.cei.load.domain;

import java.math.BigInteger;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.IdentifiableBase;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipment", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "equipment_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.equipment_seq", allocationSize = 1)
@Getter
@Setter
public class Equipment extends IdentifiableBase {
	
	@Column(name = "equipment_name")
	String equipmentName;
	
	@Column(name = "equipment_description")
	String equipmentDescription;
	
	@Column(name = "containter_size")
	Short containerSize;
	
	@Column(name = "container_weight")
	BigInteger containerWeight;
	
	@Column(name = "container_height")
	BigInteger containerHeight;
	
	@Column(name = "is_active")
	boolean isActive;
}
