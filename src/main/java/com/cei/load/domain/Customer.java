package com.cei.load.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;


/**
 * The Class Customer.
 */
@Entity
@Table(name = "customer", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.customer_seq", allocationSize = 1)
@Getter
@Setter
public class Customer extends Auditable<Long> {
	
	/** The company. */
	@Column(name = "company")
	String company;

	/** The customer email. */
	@Column(name="customer_email")
	String customerEmail;
	
	/** The is active. */
	@Column(name = "is_active")
	boolean isActive;
}
