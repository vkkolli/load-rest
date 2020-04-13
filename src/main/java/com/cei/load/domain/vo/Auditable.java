package com.cei.load.domain.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Auditable.
 *
 * @param <ID> the generic type
 */
@Getter
@Setter
public abstract class Auditable<ID extends Serializable> extends Identifiable<Long> {
	
	/** The created by. */
	@Column(name = "created_by")
	Long createdBy;

	/** The created date. */
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, insertable = true, updatable = false)
//	@Type(type = "UtcDateType")
	Date createdDate;

	/** The modified by. */
	@Column(name = "modified_by")
	Long modifiedBy;

	/** The modified date. */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", insertable = true, updatable = true)
//	@Type(type = "UtcDateType")
	Date modifiedDate;


}
