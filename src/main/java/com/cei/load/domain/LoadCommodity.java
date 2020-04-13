package com.cei.load.domain;

import java.math.BigInteger;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.Setter;


/**
 * The Class LoadCommodity.
 */
@Entity
@Table(name = "load_commodity", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_commodity_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.load_commodity_seq", allocationSize = 1)
@Getter
@Setter
public class LoadCommodity extends Auditable<Long> {
	
	/** The load. */
	@Column(name = "load_id")
	Long load; //fk
	
	/** The commodity name. */
	@Column(name = "commodity_name")
	String commodityName;
	
	/** The commodity weight. */
	@Column(name = "commodity_weight")
	BigInteger commodityWeight;
	
	/** The commodity length. */
	@Column(name = "commodity_length")
	BigInteger commodityLength;
	
	/** The commodity value. */
	@Column(name = "commodity_value")
	BigInteger commodityValue;
}
