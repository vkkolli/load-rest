package com.cei.load.domain.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class Auditable<ID extends Serializable> extends Identifiable<Long> {
	
	@Column(name = "created_by")
	Long createdBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, insertable = true, updatable = false)
//	@Type(type = "UtcDateType")
	Date createdDate;

	@Column(name = "modified_by")
	Long modifiedBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", insertable = true, updatable = true)
//	@Type(type = "UtcDateType")
	Date modifiedDate;


}
