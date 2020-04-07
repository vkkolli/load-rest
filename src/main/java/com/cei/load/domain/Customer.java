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
@Table(name = "customer", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.customer_seq", allocationSize = 1)
@Getter
@Setter
public class Customer extends IdentifiableBase {
	
	@Column(name = "company")
	String company;
	
	@Column(name = "is_active")
	boolean isActive;
}
