package com.cei.load.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.IdentifiableBase;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trip_type", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "trip_type_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.trip_type_seq", allocationSize = 1)
@Getter
@Setter
public class TripType extends IdentifiableBase {
	
	@Column(name = "trip_type_name")
	String tripTypeName;
	
	@Column(name = "description")
	String description;
}
