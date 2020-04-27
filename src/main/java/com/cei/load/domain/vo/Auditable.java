package com.cei.load.domain.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Auditable.
 *
 * @param <ID> the generic type
 */
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@MappedSuperclass
public abstract class Auditable<ID extends Serializable> extends Identifiable<Long> {
	
	/** The created by. */
	@CreatedBy
	@Column(name = "created_by")
	Long createdBy;

	/** The created date. */
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, insertable = true, updatable = false)
	Date createdDate;

	/** The modified by. */
	@LastModifiedBy
	@Column(name = "modified_by")
	Long modifiedBy;

	/** The modified date. */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", insertable = true, updatable = true)
	Date modifiedDate;


}
