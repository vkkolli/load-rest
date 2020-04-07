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
@Table(name = "load_status", schema = "tpl")
@AttributeOverride(name = "id", column = @Column(name = "load_status_id"))
@SequenceGenerator(name = "seq", sequenceName = "tpl.load_status_seq", allocationSize = 1)
@Getter
@Setter
public class LoadStatus extends IdentifiableBase {
	
	@Column(name = "load_status_name")
	String loadStatusName;
	
	@Column(name = "description")
	String description;
}
