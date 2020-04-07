package com.cei.load.domain.vo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Identifiable<ID extends Serializable> {

	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	Long id;
}
