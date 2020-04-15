package com.cei.load.model;

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
	BigInteger commodityWeight;

	/** The commodity length. */
	BigInteger commodityLength;

	/** The commodity value. */
	BigInteger commodityValue;

}
