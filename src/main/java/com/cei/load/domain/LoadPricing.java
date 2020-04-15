package com.cei.load.domain;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "load_pricing", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_pricing_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.load_pricing_seq", allocationSize = 1)
@Getter
@Setter
public class LoadPricing extends Auditable<Long>{

	/** The load. */
	@ManyToOne
	@JoinColumn(name = "load_id")
	@JsonIgnore
	private Load load;

	@Column(name = "pricing_type_id")
	Long pricingTypeId;

	@Column(name = "pricing_line_item")
	Long pricingLineItem;

	@Column(name = "pricing_line_item_value")
	BigDecimal pricingLineItemValue;

	@Column(name = "pricing_line_item_subtotal")
	BigDecimal pricingLineItemSubtotal;
}
