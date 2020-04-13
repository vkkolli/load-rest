package com.cei.load.domain.vo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Identifiable.
 *
 * @param <ID> the generic type
 */
@MappedSuperclass
@Getter
@Setter
public abstract class Identifiable<ID extends Serializable> {

	/** The id. */
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	Long id;
}
