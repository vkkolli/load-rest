package com.cei.load.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LoadPricingDTO.
 */
@Getter
@Setter
public class LoadPricingDTO {

	/** The id. */
	Long id;
	
	/** The pricing type id. */
	Long pricingTypeId;

	/** The pricing line item. */
	Long pricingLineItem;

	/** The pricing line item value. */
	BigDecimal pricingLineItemValue;

	/** The pricing line item subtotal. */
	BigDecimal pricingLineItemSubtotal;
}
