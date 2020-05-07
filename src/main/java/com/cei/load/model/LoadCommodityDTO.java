package com.cei.load.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LoadCommodityDTO.
 */
@Getter
@Setter
public class LoadCommodityDTO {
	
	/** The id. */
	Long id;
	
	/** The commodity name. */
	String commodityName;

	/** The commodity weight. */
	BigDecimal commodityWeight;

	/** The commodity length. */
	BigDecimal commodityLength;

	/** The commodity value. */
	BigDecimal commodityValue;

}
