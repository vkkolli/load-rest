package com.cei.load.domain.vo;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdentifiableBase {
	
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	Long id;
	
	@Column(name = "created_by")
	Long createdBy;
	
	@Column(name = "created_date")
	LocalTime createdDate;
	
	@Column(name = "modified_by")
	Long modifiedBy;
	
	@Column(name = "modified_date")
	LocalTime modifiedDate;
	
}
